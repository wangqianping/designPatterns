package patterns;

/**
 * 职责链模式
 */
public class ChainResponsibility {

    public static void main(String[] args) {

        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        ColleageApprover colleageApprover = new ColleageApprover("刘院长");
        SchoolApprover schoolApprover = new SchoolApprover("王校长");

        //形成职责链
        departmentApprover.setAppprover(colleageApprover);
        colleageApprover.setAppprover(schoolApprover);

        PurchaseRequest purchaseRequest = new PurchaseRequest(1);
        purchaseRequest.setPrice(50000);
        departmentApprover.processRequest(purchaseRequest);

    }
}

class PurchaseRequest {
    int id;
    int price;


    public PurchaseRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

abstract class Appprover {

    String name;
    Appprover appprover;

    public Appprover(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appprover getAppprover() {
        return appprover;
    }

    public void setAppprover(Appprover appprover) {
        this.appprover = appprover;
    }

    abstract void processRequest(PurchaseRequest purchaseRequest);
}

class DepartmentApprover extends Appprover {

    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    void processRequest(PurchaseRequest purchaseRequest) {
        if (5000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() < 10000) {
            System.out.println("编号为" + purchaseRequest.getId() + "的订单被" + name + "审批了");
        } else {
            appprover.processRequest(purchaseRequest);
        }
    }
}

class ColleageApprover extends Appprover {

    public ColleageApprover(String name) {
        super(name);
    }

    @Override
    void processRequest(PurchaseRequest purchaseRequest) {
        if (10000 <= purchaseRequest.getPrice() && purchaseRequest.getPrice() < 30000) {
            System.out.println("编号为" + purchaseRequest.getId() + "的订单被" + name + "审批了");
        } else {
            appprover.processRequest(purchaseRequest);
        }
    }
}

class SchoolApprover extends Appprover {

    public SchoolApprover(String name) {
        super(name);
    }

    @Override
    void processRequest(PurchaseRequest purchaseRequest) {
        if (30000 <= purchaseRequest.getPrice()) {
            System.out.println("编号为" + purchaseRequest.getId() + "的订单被" + name + "审批了");
        } else {
            appprover.processRequest(purchaseRequest);
        }
    }
}