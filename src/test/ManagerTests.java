package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import AeiatonEntityBuilder.Manager;

public class ManagerTests {
    
    @Test
    public void generalTest() {
        Manager m = new Manager();
        
        m.addEntity();
        m.addComponent(0, 1, new String[] {"1", "1", "2", "2"});
        m.addComponent(0, 2, new String[] {"sample text"});
        m.addComponent(0, 4, new String[] {"0.233", "0.747745"});
        m.addEntity();
        m.addComponent(1, 1, new String[] {"3", "3", "3", "3"});
        m.deleteComponent(0, 2);
        m.addComponent(1, 2, new String[] {"second sample text"});
        m.updateComponent(0, 4, new String[] {"0.31", "1.12"});
        
        String[] stats = m.getStats();
        assertEquals("2 entities", stats[1]);
        assertEquals("4 total components used", stats[2]);
        
        m.setFilePath("test.txt");
        m.write();
        
    }

}
