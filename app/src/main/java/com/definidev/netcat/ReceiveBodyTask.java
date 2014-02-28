package com.definidev.netcat;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketAddress;

/**
 * Created by tlehman on 2014-Feb-26.
 *
 * This AsyncTask wraps a socket that listens on a port specified by the user
 */
public class ReceiveBodyTask extends AsyncTask<String, Void, String> {

    private EditText bodyEdit;

    @Override
    public String doInBackground(String... args) {
        int port = Integer.parseInt(args[0]);
        ServerSocket server;
        Socket socket;
        DataInputStream dataInputStream;
        String body = "";

        try {
            server = new ServerSocket(port);
            socket = server.accept();
            dataInputStream = new DataInputStream(socket.getInputStream());
            body = dataInputStream.readUTF();
            Log.i("body data: ", body);
        } catch (IOException e) {
            Log.e("IOException : ", e.toString());
        }
        return body;
    }

    public void setBodyEdit(EditText body) {
        bodyEdit = body;
    }

    @Override
    public void onPostExecute(String result) {
        bodyEdit.setText(result);
    }
}
