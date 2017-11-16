package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Controller  {

    public TextField textField;
    public String a="0";
    public String b="0";
    double res=0;
    public String state="0";

    public TextField textField2;
    public String aBin;
    public String bBin;
    public String stateBin="0";

    public String clearotnol(String str){
        boolean flag=true;
        String tmpRe = "";
        for(int i=0; i<str.length(); i++){
            if(flag) {
                if(str.charAt(i)=='1') {
                    tmpRe += String.valueOf(str.charAt(i));
                    flag=false;
                }
            }
            else{
                tmpRe += String.valueOf(str.charAt(i));
            }
        }
        return tmpRe;
    }

    public String obratnyi(String str){
        String tmpStr="";
        for(int i=0; i<str.toCharArray().length; i++){
            tmpStr+=str.toCharArray()[str.toCharArray().length-1-i];
        }
        return tmpStr;
    }

    public void multiplition(String i, String j){
        double mi=Double.valueOf(a);
        double mj=Double.valueOf(b);
        res=mi*mj;
        a=String.valueOf(res);
        b="0";
        state="0";
        textField.setText(String.valueOf(res));
    }
    public void dele(String i, String j){
        double di=Double.valueOf(a);
        double dj=Double.valueOf(b);
        res=di/dj;
        a=String.valueOf(res);
        b="0";
        state="0";
        textField.setText(String.valueOf(res));
    }
    public void minus(String i, String j){
        double im=Double.valueOf(a);
        double jm=Double.valueOf(b);
        res=im-jm;
        a=String.valueOf(res);
        b="0";
        state="0";
        textField.setText(String.valueOf(res));
    }
    public void plus(String aa, String bb){
        double i=Double.valueOf(aa);
        double j=Double.valueOf(bb);
        res=i+j;
        a=String.valueOf(res);
        b="0";
        state="0";
        textField.setText(String.valueOf(res));
    }
    //функции двоичнего калькулятора
    //умножения
    public String BinMulti(char[] mass,char b){
        System.out.print("Функция BinMultu: ");
        String tmpRe="";
        for(int i=0;i<mass.length; i++){
            char a=mass[mass.length-1-i];
            if(a=='0' && b=='0'){
                tmpRe+='0';
            }
            else if(a=='1' && b=='1'){
                tmpRe+='1';
            }
            else{
                tmpRe+=0;
            }

            System.out.print(mass[i]);
        }
        System.out.println("*"+b+" = "+obratnyi(tmpRe));
        return obratnyi(tmpRe);
    }
    // Сложения
    public String BinPlus(char[] aArray,char[] bArray){

        //TEST
        System.out.print("Функция BinPlus: ");
        for(int i=0;i<aArray.length;i++){
            System.out.print(aArray[i]);
        }
        System.out.print(" + ");
        for(int i=0;i<bArray.length;i++){
            System.out.print(bArray[i]);
        }
        //TEST

        String tmpresultBin="";
        //Если второй массив больше
        if(aArray.length<bArray.length){
            boolean tmp =false;
            for(int i=0; i<aArray.length; i++ ){
                char k=aArray[(aArray.length-1)-i];
                char l=bArray[(bArray.length-1)-i];
                if((l == '0') && (k == '0')){
                    if(tmp){
                        tmpresultBin+="1";
                        tmp=false;
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1' || k=='1' && l=='0' ){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=true;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                    }
                    else{
                        tmpresultBin += "0";
                    }
                    tmp=true;


                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
            for(int i=0;i<bArray.length-aArray.length; i++){
                if(tmp){
                    char k=bArray[bArray.length-aArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="01";
                    }
                    else{
                        tmpresultBin+="1";
                        tmp=false;
                    }
                }
                else{
                    tmpresultBin+=bArray[bArray.length-aArray.length-i];
                }
            }

        }
        //Если первый массив больше второго
        else if(aArray.length>bArray.length){
            boolean tmp =false;
            for(int i=0; i<bArray.length; i++ ){
                char k=aArray[(aArray.length-1)-i];
                char l=bArray[(bArray.length-1)-i];
                if((l == '0') && (k == '0')){
                    if(tmp){
                        tmpresultBin+="1";
                        tmp=false;
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1' || k=='1' && l=='0' ){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=true;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                    }
                    else{
                        tmpresultBin += "0";
                    }
                    tmp=true;


                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
            for(int i=0;i<aArray.length-bArray.length; i++){
                if(tmp){
                    char k=aArray[aArray.length-bArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="01";
                    }
                    else{
                        tmpresultBin+="1";
                        tmp=false;
                    }
                }
                else{
                    tmpresultBin+=aArray[aArray.length-bArray.length-i];
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
                        tmpresultBin+="1";
                        tmp=false;
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1' || k=='1' && l=='0' ){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=true;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                    }
                    else{
                        tmpresultBin += "0";
                    }
                    tmp=true;


                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
            if(tmp){
                tmpresultBin+="1";
                tmp=false;
            }
        }
        System.out.println(" = "+obratnyi(tmpresultBin));
        return obratnyi(tmpresultBin);
    }

    //Вычитания
    public String BinMinus(char[] aArray,char[] bArray){

        //TEST
        System.out.print("Функция BinMinus: ");
        for(int i=0;i<aArray.length;i++){
            System.out.print(aArray[i]);
        }
        System.out.print(" + ");
        for(int i=0;i<bArray.length;i++){
            System.out.print(bArray[i]);
        }
        //TEST
        String tmpresultBin="";
        if(aArray.length>bArray.length){
            boolean tmp =false;
            for(int i=0; i<bArray.length; i++ ){
                char k=aArray[(aArray.length-1)-i];
                char l=bArray[(bArray.length-1)-i];
                if((l == '0') && (k == '0')){
                    if(tmp){
                        tmpresultBin+="1";
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1'){
                    if(tmp){
                        tmpresultBin+="0";
                    }
                    else {
                        tmpresultBin += "1";
                        tmp=true;
                    }
                }
                else if(k=='1' && l=='0'){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=false;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                        tmp=true;
                    }
                    else{
                        tmpresultBin += "0";
                    }
                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
            for(int i=0;i<aArray.length-bArray.length; i++){
                if(tmp){
                    char k=aArray[aArray.length-bArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="0";
                        tmp=false;
                    }
                    else{
                        tmpresultBin+="0";
                        tmp=true;
                    }
                }
                else{
                    char k=aArray[aArray.length-bArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="1";
                    }
                    else{
                        tmpresultBin+="0";
                    }
                }
            }
        }
        //если второй массив больше чем первый
        else if(aArray.length<bArray.length){
            boolean tmp =false;
            for(int i=0; i<aArray.length; i++ ){
                char l=aArray[(aArray.length-1)-i];
                char k=bArray[(bArray.length-1)-i];
                if((l == '0') && (k == '0')){
                    if(tmp){
                        tmpresultBin+="1";
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1'){
                    if(tmp){
                        tmpresultBin+="0";
                    }
                    else {
                        tmpresultBin += "1";
                        tmp=true;
                    }
                }
                else if(k=='1' && l=='0'){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=false;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                        tmp=true;
                    }
                    else{
                        tmpresultBin += "0";
                    }
                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
            for(int i=0;i<bArray.length-aArray.length; i++){
                if(tmp){
                    char k=bArray[bArray.length-aArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="0";
                        tmp=false;
                    }
                    else{
                        tmpresultBin+="0";
                        tmp=true;
                    }
                }
                else{
                    char k=bArray[bArray.length-aArray.length-i];
                    if(k=='1'){
                        tmpresultBin+="1";
                    }
                    else{
                        tmpresultBin+="0";
                    }
                }
            }
            tmpresultBin+="-";
        }
        else if(aArray.length==bArray.length){
            boolean tmp =false;
            for(int i=0; i<bArray.length; i++ ){
                char k=aArray[(aArray.length-1)-i];
                char l=bArray[(bArray.length-1)-i];
                if((l == '0') && (k == '0')){
                    if(tmp){
                        tmpresultBin+="1";
                    }
                    else{
                        tmpresultBin+="0";
                    }

                }
                else if(k=='0' && l=='1'){
                    if(tmp){
                        tmpresultBin+="0";
                    }
                    else {
                        tmpresultBin += "1";
                        tmp=true;
                    }
                }
                else if(k=='1' && l=='0'){
                    if(tmp){
                        tmpresultBin+="0";
                        tmp=false;
                    }
                    else {
                        tmpresultBin += "1";
                    }
                }
                else if(k=='1' && l=='1' ){
                    if(tmp){
                        tmpresultBin += "1";
                        tmp=true;
                    }
                    else{
                        tmpresultBin += "0";
                    }
                }
                else {
                    tmpresultBin+="Ошибка";
                }
            }
        }
        else{
            System.out.println("Ошибка при вычислении");
        }
        System.out.println(" = "+tmpresultBin);
        return obratnyi(tmpresultBin);
    }

    //Полное умножение
    public String BinMulti_2(char[] aArray,char[] bArray){
        String tmp="";
        int razryad=1;
        for(int i=0;i<bArray.length;i++){
            if(tmp==""){
                tmp=BinMulti(aArray,bArray[bArray.length-1-i]);
            }
            else{
                String tmp2=BinMulti(aArray,bArray[bArray.length-1-i]);
                String tmp3;
                for(int j=0; j<razryad;j++){
                    tmp2+="0";
                }
                tmp3=BinPlus(tmp.toCharArray(), tmp2.toCharArray());
                razryad++;
                tmp=tmp3;
            }
        }
        return tmp;
    }





    public void N(ActionEvent actionEvent) {
        char str[]=actionEvent.getTarget().toString().toCharArray();

        if(state=="0"){
            if(res!=0){
                textField.setText("");
                res=0;
                a="0";
                b="0";
            }
            a+=str[str.length-2];
        }
        else{
            b+=str[str.length-2];
        }
        textField.setText(textField.getText()+Character.toString(str[str.length-2]));
    }

    public void oper(ActionEvent actionEvent) {
        char str[] = actionEvent.getTarget().toString().toCharArray();
        if(b!="0"){
            result();
            state=Character.toString(str[str.length - 2]);
            textField.setText(textField.getText() + state);
        }
        else {
            state = Character.toString(str[str.length - 2]);
            textField.setText(textField.getText() + state);
        }

    }
    public void result() {
        switch (state){
            case "*" :
                multiplition(a,b);
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
        a="0";
        b="0";
        state="0";
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
        char aArray[]=aBin.toCharArray();
        char bArray[]=bBin.toCharArray();
        aBin="";
        bBin="";
        String buffer="";
        switch (stateBin){
            //Сложения
            case "+" :
                textField2.setText(BinPlus(aArray,bArray));
                break;
            //Вычитания
            case "-" :
                textField2.setText(BinMinus(aArray,bArray));
                break;
            case "*" :
                textField2.setText(BinMulti_2(aArray,bArray));
                break;
            case "/" :
                //деление
                String result="";
                int f=0, k=0, g;
                for(int i=0; i<aArray.length; i++){

                    f+=Integer.valueOf(String.valueOf(aArray[i]))*(Math.pow(2,Integer.valueOf(aArray.length-1-i)));
                }
                for(int i=0; i<bArray.length; i++){

                    k+=Integer.valueOf(String.valueOf(bArray[i]))*(Math.pow(2,Integer.valueOf(bArray.length-1-i)));
                }
                g=f/k;
                System.out.println(f+"/"+k+" = "+g);
                boolean flag=true;
                while (flag){
                    if(g>=2){
                        result+=String.valueOf(g%2);
                        System.out.println(result);
                        g=g/2;
                    }
                    else{
                        flag=false;
                        result+="1";
                    }
                }
                textField2.setText(obratnyi(result));

                break;

        }
        stateBin="0";
    }
    public void clearBin(ActionEvent actionEvent) {
        textField2.setText("");
        aBin="";
        bBin="";
        stateBin="";
    }

}