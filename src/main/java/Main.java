import com.group.FresherManagement.utils.EMConfigs;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args){
        EntityManager entityManager = EMConfigs.createEntityManager();
        entityManager.getTransaction();
        return;
    }
}
