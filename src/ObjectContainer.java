import java.util.HashMap;
import java.util.Map;

public class ObjectContainer {
    Map<String, Object> objectMap;

    public ObjectContainer() {
        objectMap = new HashMap<String, Object>();
    }

    public void addObject(String name, Object object) {
        objectMap.put(name, object);
    }

    public Object getObject(String name) {
        return objectMap.get(name);
    }
}
