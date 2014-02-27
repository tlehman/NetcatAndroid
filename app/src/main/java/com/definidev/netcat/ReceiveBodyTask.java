package com.definidev.netcat;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by tlehman on 2014-Feb-26.
 *
 * This AsyncTask wraps a socket that listens on a port specified by the user
 */
public class ReceiveBodyTask extends AsyncTask<String, Void, String> {
    @Override
    public String doInBackground(String... args) {
        int port = Integer.parseInt(args[0]);
        List<Byte> bytes = new ArrayList<Byte>();

        try {
            Socket server = new Socket();
            InetSocketAddress addr = new InetSocketAddress("0.0.0.0", port);
            server.bind(addr);
            InputStream stream = server.getInputStream();

            while(true) {
                bytes.add((byte)stream.read());
            }
        } catch (IOException e) {
            Log.e("IOExceptionTag", e.toString());
        }

        return bytes.toString();
    }
}
