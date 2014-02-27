package com.definidev.netcat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.lang.Integer;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by tlehman at 2014-Feb-13
 *
 * This AsyncTask wraps a socket that connects to (ip,port) and writes
 * the contents of body as a stream of bytes.
 */
public class SendBodyTask extends AsyncTask<String, Void, Void> {

	@Override
	protected Void doInBackground(String... args) {
		try {
			String ip = args[0];
			int port = Integer.parseInt(args[1]);
			String body = args[2];

			InetSocketAddress addr = new InetSocketAddress(ip, port);
			Socket socket = new Socket();
			socket.connect(addr);
			OutputStream stream = socket.getOutputStream();
			stream.write(body.getBytes());
			socket.close();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			Log.e("SocketExceptionTag", e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.e("IOExceptionTag", e.toString());
		}
		return null;
	}

}
