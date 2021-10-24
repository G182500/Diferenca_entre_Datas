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
        boolean datas_Validas = true;
        
        for(int i=0; i<2; i++){  //recebe e verifica as duas datas
            try{
                data = s.next();
                datas[i]=(Date)formatter.parse(data);  //conversao
            }catch(ParseException e){  //erro na conversao
                datas_Validas = false;
                System.out.println("Data invalida: "+data+"! Formato esperado = dd/mm/yyyy");
            }
        }
        
        if(datas_Validas){ //se as duas foram validas
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
}
