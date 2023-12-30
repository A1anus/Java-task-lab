package Lab.lab8;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();

        dataManager.registerDataProcessor(new FilterProcessor());
        dataManager.registerDataProcessor(new TransformProcessor());
        dataManager.registerDataProcessor(new AggregateProcessor());

        dataManager.loadData("D:/ITIP_LABS/LABS/src/lab8/input.txt");
        dataManager.processData();
        dataManager.saveData("D:/ITIP_LABS/LABS/src/lab8/output.txt");
    }
}
