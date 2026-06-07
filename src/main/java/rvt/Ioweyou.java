package rvt;

import java.util.HashMap;

public class Ioweyou { 
    HashMap<String, Double> debtor;
    public Ioweyou(){
        this.debtor = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        this.debtor.put(toWhom,amount);
    }
    public double howMuchDoIOweTo(String toWhom) {
        return
        debtor.get(toWhom);
    }
    public static void main(String[] args) {
        Ioweyou mattsIoweyou = new Ioweyou();
        mattsIoweyou.setSum("Arthur", 51.5);
        mattsIoweyou.setSum("Michael", 30);

        System.out.println(mattsIoweyou.howMuchDoIOweTo("Arthur"));
        System.out.println(mattsIoweyou.howMuchDoIOweTo("Michael"));
    }
}
