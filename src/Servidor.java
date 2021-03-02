import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args){
        ServerSocket servidor = null;
        Socket socket_cliente = null;
        DataInputStream entrada;
        DataOutputStream salida;

        final int PUERTO = 5000;

        try{
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");

            while(true) {
                socket_cliente = servidor.accept();
                System.out.print("Cliente conectado");

                entrada = new DataInputStream(socket_cliente.getInputStream());
                salida = new DataOutputStream(socket_cliente.getOutputStream());

                String mensaje = entrada.readUTF();
                System.out.println(mensaje);

                salida.writeUTF("Hola mundo desde el servidor!");

                socket_cliente.close();
                System.out.println("Cliente desconectado");

            }
        } catch (IOException excepcion) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
}