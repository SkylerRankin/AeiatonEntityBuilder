package AeiatonEntityBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Manager {
    
    private ArrayList<ComponentList> data = new ArrayList<>();
    private String file_path;
    
    public void setFilePath(String s) {
        file_path = s;
    }
    
    public void open() {
        if (file_path == null)
            throw new IllegalStateException();
        //TODO call parser to populate data hashmap
    }
    
    public void addEntity() {
        data.add(new ComponentList());
    }
    
    public void addComponent(int entity, int component, String[] values) {
        data.get(entity).addComponent(component, values);
    }
    
    public boolean deleteEntity(int entity) {
        return data.remove(entity) != null;
    }
    
    public void deleteComponent(int entity, int component) {
        data.get(entity).remove(component);
    }
    
    public void updateComponent(int entity, int component, String[] values) {
        data.get(entity).addComponent(component, values);
    }
    
    public ArrayList<String[]> getData() {
        ArrayList<String[]> list = new ArrayList<>();
        String[] a;
        int i;
        for (ComponentList l : data) {
            a = new String[l.count()];
            i=0;
            for (Entry<Integer, String[]> e : l.components.entrySet())
                a[i++] = e.getKey() + " - " + join(e.getValue(), ",");
            list.add(a);
        }
        return list;
    }
    
    public String[] getStats() {
        String[] stats = new String[3];
        stats[0] = file_path;
        stats[1] = data.size() + " entities";
        int total = 0;
        for (ComponentList l : data)
            total += l.count();
        stats[2] = total + " total components used";
        return stats;
    }
    
    public void write() {
        if (file_path == null)
            throw new IllegalStateException();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file_path));
            for (ComponentList c : data) {
                bw.write(c.getComponents());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            
        }
    }
    
    private String join(String[] a, String d) {
        StringBuilder sb = new StringBuilder();
        for (String s : a)
            sb.append(s+d);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private class ComponentList {
        private HashMap<Integer, String[]> components = new HashMap<>();
        
        public ComponentList() {}
        
        public void addComponent(int comp, String[] values) {
            components.put(comp, values);
        }
        public void remove(int comp) {
            components.remove(comp);
        }
        public int count() {
            return components.size();
        }
        public String getComponents() {
            StringBuilder sb = new StringBuilder();
            for (Entry<Integer, String[]> e : components.entrySet()) {
                sb.append(":"+e.getKey()+":");
                for (String s : e.getValue())
                    sb.append(s+",");
                sb.deleteCharAt(sb.length()-1);
            }
            return sb.toString();
        }
    }

}
