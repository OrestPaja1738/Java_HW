import java.util.ArrayList;

public class Painter {
private String name;
private String surname;
private  int birthYear;
private ArrayList<Painting> paintingsList;

    public Painter(String name,String surname,int birthYear){
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        paintingsList = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getBirthYear(){
        return birthYear;
    }

    public void addPainting(Painting p){
        paintingsList.add(p);
    }
    public void removePainting(String title){
        boolean status = false;
        for(int i = 0; i < paintingsList.size();i++){
           if (paintingsList.get(i).getTitle().equalsIgnoreCase(title)) {
            paintingsList.remove(i);
            status = true;
            break;
           }
        }
        if (!status) {
            System.out.println("Title not found in the paintings list");
        }
    }
    public void sellPainting(String title){
        boolean status = false;
        for(int i = 0;i < paintingsList.size();i++){
            if (paintingsList.get(i).getTitle().equalsIgnoreCase(title)){
                if (paintingsList.get(i).isSold() == true) {
                    System.out.println("Cannot sell,painting " + title + " is already sold");
                }
                else{
                    paintingsList.get(i).setSoldStatus(true);
                    System.out.println("Painting: " + title + " succesfully sold");
                }
                status = true;
                break;
            }
        }
        if (!status) {
            System.out.println("Title not found in the paintings list");
        }
    }
    public int numberOfPaintings(){
        return paintingsList.size();
    }
    public int numberOfSoldPaintings(){
        int cnt = 0;
        for(int i = 0;i < paintingsList.size();i++){
            if (paintingsList.get(i).isSold() == true) {
                cnt++;
            }
        }
        return cnt;
    }
    public double totalIncome(){
        double sum = 0;
        for(int i = 0;i < paintingsList.size();i++){
            sum += paintingsList.get(i).getPrice();
        }
        return sum;
    }
    public double expectedIncome(){
        double sum  = 0;
        for(int i = 0;i < paintingsList.size();i++){
            if (paintingsList.get(i).isSold() == false) {
                sum += paintingsList.get(i).getPrice();
            }
        }
        return sum;
    }
    public String mostExpensiveSoldPainting(){
        double maxPrice = 0;
        String maxTitle = "NULL";
        for(int i = 0; i < paintingsList.size();i++){
            if (paintingsList.get(i).isSold() && paintingsList.get(i).getPrice() > maxPrice) {
                maxPrice = paintingsList.get(i).getPrice();
                maxTitle  = paintingsList.get(i).getTitle();
            }
        }
        return maxTitle;
    }
    public String largestPainting(){
        int maxArea = 0;
        String maxTitle = "NULL";
        for(int i = 0;i < paintingsList.size();i++){
            int Area = paintingsList.get(i).getLength() * paintingsList.get(i).getWidth();
            if (Area > maxArea) {
                maxArea = Area;
                maxTitle = paintingsList.get(i).getTitle();
            }
        }
        return maxTitle;
    }
}
