package code.webdkmh.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    private EntityManager entityManager;

    @RequestMapping(value = "")
    public String home(Model model, @RequestParam("entityClass") String entityClass) {
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();
        List<String> listEntitiesName = new ArrayList<>();
        LinkedHashSet<String> listEntitiesVariable = new LinkedHashSet<>();
        Map<String, List<Object>> map = new HashMap<>();
        int keyCount = 0;
        for (EntityType<?> entityType : entityTypes) {
            listEntitiesName.add(entityType.getName());
            if (entityType.getName().equals(entityClass)) {
                try {
                    for (Attribute<?, ?> entityType2 : entityType.getIdClassAttributes()) {
                        listEntitiesVariable.add(entityType2.getName());
                        keyCount++;
                    }
                } catch (Exception e) {
                    listEntitiesVariable.add(entityType.getId(Object.class).getName());
                    keyCount++;
                }
                for (Attribute<?, ?> entityType2 : entityType.getAttributes()) {
                    if (!entityType2.isAssociation()) {
                        listEntitiesVariable.add(entityType2.getName());
                        List<Object> listEntitiesRecord = new ArrayList<>();
                        for (Object entityType3 : entityManager
                                .createQuery("Select t." + entityType2.getName() + " from "
                                        + entityType.getJavaType().getSimpleName() + " t")
                                .getResultList()) {
                            listEntitiesRecord.add(entityType3);
                        }
                        map.put(entityType2.getName(), listEntitiesRecord);
                    }
                }
            }
        }
        List<String> listEntitiesVariableAfter = new ArrayList<String>(listEntitiesVariable);
        model.addAttribute("listEntitiesName", listEntitiesName);
        model.addAttribute("listEntitiesVariable", listEntitiesVariableAfter);
        model.addAttribute("keySize", keyCount);
        model.addAttribute("listEntitiesRecord", map);
        return "home";
    }

    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            Throwable.class })
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    @ResponseBody
    public String getSearchUserProfiles(@RequestBody String search, @RequestParam("entityClass") String entityClass,
            HttpServletRequest request) {
        Gson gson = new Gson();
        try {
            Object target2 = gson.fromJson(search,
                    Class.forName("code.webdkmh.dao.entities." + entityClass));
            entityManager.merge(target2);
            // List<Object> target3 = gson.fromJson(search, new TypeToken<List<Object>>() {
            // }.getType());
            // for (Object object : target3) {
            // Object target4 = gson.fromJson(object.toString(),
            // Class.forName("code.webdkmh.dao.entities." + entityClass));
            // entityManager.merge(target4);
            // }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "home";
    }

}
