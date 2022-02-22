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
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String loadEntity(Model model, @RequestParam("entityClass") String entityClass) {
        Set<EntityType<?>> entityTypes = entityManager.getMetamodel().getEntities();
        List<String> listEntitiesName = new ArrayList<>();
        List<String> listLinkedEntityClassName = new ArrayList<>();
        Map<String, List<Object>> listLinkedEntity = new HashMap<>();
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
                        System.out.println(entityType2.getJavaType().getName());
                        List<Object> listEntitiesRecord = new ArrayList<>();
                        for (Object entityType3 : entityManager
                                .createQuery("Select t." + entityType2.getName() + " from "
                                        + entityType.getJavaType().getSimpleName() + " t")
                                .getResultList()) {
                            listEntitiesRecord.add(entityType3);
                        }
                        map.put(entityType2.getName(), listEntitiesRecord);
                    }
                    if (entityType2.getPersistentAttributeType() != PersistentAttributeType.BASIC) {
                        listLinkedEntityClassName.add(entityType2.getName());

                    }
                }
            }
        }
        for (EntityType<?> entityType : entityTypes) {
            for (String string : listLinkedEntityClassName) {
                if (entityType.getName().toLowerCase().equals(string.toLowerCase())) {
                    try {
                        String keyOfThisEntity = entityType.getId(Object.class).getName();
                        if (listEntitiesVariable.contains(keyOfThisEntity)) {
                            for (Attribute<?, ?> entityType2 : entityType.getAttributes()) {
                                if (entityType2.getName().equals(keyOfThisEntity)) {
                                    List<Object> listEntitiesRecord = new ArrayList<>();
                                    for (Object entityType3 : entityManager
                                            .createQuery("Select t." + entityType2.getName() + " from "
                                                    + entityType.getJavaType().getSimpleName() + " t")
                                            .getResultList()) {
                                        listEntitiesRecord.add(entityType3);
                                    }
                                    listLinkedEntity.put(keyOfThisEntity, listEntitiesRecord);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        List<String> listEntitiesVariableAfter = new ArrayList<String>(listEntitiesVariable);
        model.addAttribute("listEntitiesName", listEntitiesName);
        model.addAttribute("listEntitiesVariable", listEntitiesVariableAfter);
        model.addAttribute("entityClassModel", entityClass);
        model.addAttribute("listLinkedEntity", listLinkedEntity);
        model.addAttribute("keySize", keyCount);
        model.addAttribute("listEntitiesRecord", map);
        return "home";
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/updateEntity", method = RequestMethod.POST)
    public String updateEntity(@RequestBody String json, @RequestParam("entityClass") String entityClass,
            HttpServletRequest request) {
        Gson gson = new Gson();
        try {
            Object target = gson.fromJson(json, Class.forName("code.webdkmh.dao.entities." + entityClass));
            entityManager.merge(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/updateEntityList", method = RequestMethod.POST)
    public String updateEntityList(@RequestBody String json, @RequestParam("entityClass") String entityClass,
            HttpServletRequest request) {
        Gson gson = new Gson();
        try {
            List<Object> listEntities = gson.fromJson(json, new TypeToken<List<Object>>() {
            }.getType());
            for (Object object : listEntities) {
                Object target = gson.fromJson(object.toString(),
                        Class.forName("code.webdkmh.dao.entities." + entityClass));
                entityManager.merge(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.POST)
    public String deleteEntity(@RequestBody String json, @RequestParam("entityClass") String entityClass,
            @RequestParam("entityParent") String entityParent,
            HttpServletRequest request) {
        Gson gson = new Gson();
        try {
            Object target = gson.fromJson(json, Class.forName(entityClass));
            if (!entityClass.contains("Id")) {
                String convertedToString = String.valueOf(target);
                convertedToString = convertedToString.substring(convertedToString.indexOf('=') + 1,
                        convertedToString.indexOf('}'));
                System.out.println(convertedToString + "ok ok");
                target = entityManager.find(Class.forName("code.webdkmh.dao.entities." + entityParent),
                        convertedToString);
            } else {

                target = entityManager.find(Class.forName("code.webdkmh.dao.entities." + entityParent), target);
            }
            entityManager.remove(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/deleteEntityList", method = RequestMethod.POST)
    public String deleteEntityList(@RequestBody String search, @RequestParam("entityClass") String entityClass,
            @RequestParam("entityParent") String entityParent,
            HttpServletRequest request) {
        Gson gson = new Gson();
        try {
            List<Object> listEntities = gson.fromJson(search, new TypeToken<List<Object>>() {
            }.getType());
            for (Object object : listEntities) {
                Object target;
                if (!entityClass.contains("Id")) {
                    String convertedToString = object.toString();
                    convertedToString = convertedToString.substring(convertedToString.indexOf('=') + 1,
                            convertedToString.indexOf('}'));
                    target = entityManager.find(Class.forName("code.webdkmh.dao.entities." + entityParent),
                            convertedToString);
                } else {
                    target = gson.fromJson(object.toString(),
                            Class.forName(entityClass));
                    target = entityManager.find(Class.forName("code.webdkmh.dao.entities." + entityParent), target);
                }
                entityManager.remove(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }
}
