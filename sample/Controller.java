package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller  {

    public TextField textField;
    public double a;
    public double b;
    public String state="0";

    public TextField textField2;
    public String aBin;
    public String bBin;
    public String stateBin="0";

    public void multiplition(double i, double j){
        double res=i*j;
        textField.setText(String.valueOf(res));
    }
    public void dele(double i, double j){
        double res=i/j;
        textField.setText(String.valueOf(res));
    }
    public void minus(double i, double j){
        double res=i-j;
        textField.setText(String.valueOf(res));
    }
    public void plus(double i, double j){
        double res=i+j;
        textField.setText(String.valueOf(res));
    }
    public void N(ActionEvent actionEvent) {
        System.out.println(actionEvent.getTarget());
        char str[]=actionEvent.getTarget().toString().toCharArray();
        System.out.println(str[str.length-2]);
        if(state=="0"){
            textField.setText(textField.getText()+Character.toString(str[str.length-2]));
        }
        else{
            textField.setText(textField.getText()+Character.toString(str[str.length-2]));
        }

    }

    public void oper(ActionEvent actionEvent) {
        a=Double.valueOf(textField.getText());
        textField.setText("");
        System.out.println(actionEvent.getTarget());
        char str[]=actionEvent.getTarget().toString().toCharArray();
        state=Character.toString(str[str.length-2]);
    }

    public void result(ActionEvent actionEvent) {
        b=Double.valueOf(textField.getText());
        switch (state){
            case "*" :
                multiplition(a,5);
                break;
            case "/" :
                dele(a,b);
                break;
            case "+" :
                plus(a,b);
                break;
            case "-" :
                minus(a,b);
                break;

        }
    }

    public void clear(ActionEvent actionEvent) {

        textField.setText("");
    }

    public void portal(ActionEvent actionEvent) {
        System.out.print("fvfdvf");
    }


//    public void portal(ActionEvent actionEvent) throws IOException {
//        Stage primaryStage = new Stage();
//        Parent root;
//        root = FXMLLoader.load(getClass().getResource("binary.fxml"));
//        Scene normal=new Scene(root, 300, 275);
//        primaryStage.setScene(normal);
//        primaryStage.show();
//
//    }

    //Binary Calculator

    public void numbe(ActionEvent actionEvent){
        System.out.println(actionEvent.getTarget());
        char str[]=actionEvent.getTarget().toString().toCharArray();
        System.out.println(str[str.length-2]);
        if(stateBin=="0"){
            textField2.setText(textField2.getText()+Character.toString(str[str.length-2]));
        }
        else{
            textField2.setText(textField2.getText()+Character.toString(str[str.length-2]));
        }
    }


    public void opertionBinary(ActionEvent actionEvent){
        aBin=textField2.getText();
        textField2.setText("");
        System.out.println(actionEvent.getTarget());
        char str[]=actionEvent.getTarget().toString().toCharArray();
        stateBin=Character.toString(str[str.length-2]);

    }

    public void resultBin(ActionEvent actionEvent) {
        String resultBin="";
        bBin=textField2.getText();
        switch (stateBin){
            case "+" :
                char aArray[]=aBin.toCharArray();
                char bArray[]=bBin.toCharArray();
                if(aArray.length<bArray.length){
                }
                //Если первый массив больше второго
                else if(aArray.length>bArray.length){
                    boolean tmp =false;
                    for(int i=0; i<bArray.length; i++ ){
                        char k=aArray[(aArray.length-1)-i];
                        char l=bArray[(bArray.length-1)-i];
                        if((l == '0') && (k == '0')){
                            if(tmp){
                                resultBin+="1";
                                tmp=false;
                            }
                            else{
                                resultBin+="0";
                            }

                        }
                        else if(k=='0' && l=='1' || k=='1' && l=='0' ){
                            if(tmp){
                                resultBin+="0";
                                tmp=true;
                            }
                            else {
                                resultBin += "1";
                            }
                        }
                        else if(k=='1' && l=='1' ){
                            if(tmp){
                                resultBin += "1";
                            }
                            else{
                                resultBin += "0";
                            }
                            tmp=true;


                        }
                        else {
                            resultBin+="Ошибка";
                        }
                    }
                    for(int i=0;i<aArray.length-bArray.length; i++){
                        System.out.println("Второй цикл "+resultBin);
                        if(tmp){
                            char k=aArray[aArray.length-bArray.length-i];
                            if(k=='1'){
                                resultBin+="01";
                            }
                            else{
                                resultBin+="1";
                                tmp=false;
                            }
                        }
                        else{
                            resultBin+=aArray[aArray.length-bArray.length-i];
                        }
                    }
                }
                //Если массивы равны
                else{
                    boolean tmp =false;
                    for(int i=0; i<aArray.length; i++ ){
                        char k=aArray[(aArray.length-1)-i];
                        char l=bArray[(bArray.length-1)-i];
                        if((l == '0') && (k == '0')){
                            if(tmp){
                                resultBin+="1";
                                tmp=false;
                            }
                            else{
                                resultBin+="0";
                            }

                        }
                        else if(k=='0' && l=='1' || k=='1' && l=='0' ){
                            if(tmp){
                                resultBin+="0";
                                tmp=true;
                            }
                            else {
                                resultBin += "1";
                            }
                        }
                        else if(k=='1' && l=='1' ){
                            if(tmp){
                                resultBin += "1";
                            }
                            else{
                                resultBin += "0";
                            }
                            tmp=true;


                        }
                        else {
                            resultBin+="Ошибка";
                        }
                    }
                    if(tmp){
                        resultBin+="1";
                        tmp=false;
                    }
                }

                System.out.println("Результать = "+resultBin);
                String buffer="";
                for(int i=0; i<resultBin.toCharArray().length; i++){
                    buffer+=resultBin.toCharArray()[resultBin.toCharArray().length-1-i];
                }
                textField2.setText(buffer);
                break;
            case "-" :
                dele(a,b);
                break;
            case "*" :
                plus(a,b);
                break;
            case "/" :
                minus(a,b);
                break;

        }
    }
}