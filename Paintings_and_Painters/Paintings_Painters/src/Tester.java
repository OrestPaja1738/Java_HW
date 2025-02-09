public class Tester {
    public static void main(String[] args) {
    Painting p1 = new Painting("The lake", 40, 75, 83.5, true);
    Painting p2 = new Painting("Portrait", 50, 90, 90.5, true);
    Painting p3 = new Painting("Birds", 60, 95, 92.5, false);
    Painting p4 = new Painting("Encounter", 80, 45, 100.5, true);
    Painting p5 = new Painting("Sky", 80, 120, 110.5, false);
    Painting p6 = new Painting("Happiness", 90, 80, 88.5, true);
    Painter painter1 = new Painter("Anne", "Hayes", 1974);
    
    painter1.addPainting(p1);
    painter1.addPainting(p2);
    painter1.addPainting(p3);
    painter1.addPainting(p4);
    painter1.addPainting(p5);
    painter1.addPainting(p6);
    
    System.out.println("Some information about the painter:"+ painter1.getName()+" "+ painter1.getSurname()+ ": ");
    System.out.println("The number of paintings is:"+ painter1.numberOfPaintings());
    System.out.println("The number of sold paintings is:"+ painter1.numberOfSoldPaintings());
    System.out.println("Income from the sold paintings is:"+ painter1.totalIncome());
    System.out.println("Expected income from the unsold paintings is:"+ painter1.expectedIncome());
    System.out.println("The most expensive sold painting is:"+ painter1.mostExpensiveSoldPainting());
    System.out.println("The largest painting is:"+ painter1.largestPainting());
    painter1.sellPainting("Sky");
    }
}
