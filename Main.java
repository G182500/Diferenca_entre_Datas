import java.text.ParseException;  //biblioteca para conversão de texto
import java.util.Scanner; //biblioteca para entrada de dados
import java.util.Date; //biblioteca para utilizar datas
import java.text.SimpleDateFormat; //biblioteca para formatar texto em datas

class Main {
    public static void main(String[] args) throws ParseException{
        Scanner s = new Scanner(System.in);
                                                      //como a data vai estar representada na string
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false);
        
        Date datas[] = new Date[2];
        String data = "";
        
        for(int i=0; i<2; i++){  //recebe e verifica as duas datas
            try{
                data = s.nextLine();
                datas[i]=(Date)formatter.parse(data.trim());  //conversao Obs: trim() cria uma NOVA string sem espaços em branco no começo e/ou fim
            }catch(ParseException e){  //erro na conversao
                System.out.println("Data invalida: "+data);
                System.exit(0); //encerra o programa
            }
        }
        
        if(datas[0].before(datas[1])){
            long dias = (datas[1].getTime()-datas[0].getTime()+ 3600000);
            System.out.println(dias/86400000L);
        }
        else{
            long dias = (datas[0].getTime()-datas[1].getTime()+ 3600000);
            System.out.println(dias/86400000L);
        }
    }
}
