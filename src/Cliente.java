import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    
    public static void main(String[] args){

        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream entrada;
        DataOutputStream salida;

        try {
            Socket socket = new Socket(HOST, PUERTO);

            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            String mensaje = entrada.readUTF();
            System.out.println(mensaje);
            socket.close();

        } catch (IOException excepcion) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, excepcion);
        }        
    }
}
