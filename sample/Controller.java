package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller {
    public TextField textField;
    public double a;
    public double b;
    public char oper;
    public String state="0";
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
}