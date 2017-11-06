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
        state=Character.toString(str[str.length-2]);

    }

    public void resultBin(ActionEvent actionEvent) {
        String resul="";
        bBin=textField2.getText();
        switch (stateBin){
            case "*" :
                char aArray[]=aBin.toCharArray();
                char bArray[]=bBin.toCharArray();
                int len;
                if(aArray.length<bArray.length){
                    len=bArray.length-1;
                }
                else if(aArray.length>bArray.length){
                    len=aArray.length-1;
                }
                else{
                    len=aArray.length-1;
                }
                for(int i=0; i<len; i++ ){
                    char k=aArray[aArray.length-i];
                    char l=aArray[aArray.length-i];
                    if(k==0 && l==0 ){

                    }
                }

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
}