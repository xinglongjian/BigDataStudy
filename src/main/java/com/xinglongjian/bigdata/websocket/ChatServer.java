package com.xinglongjian.bigdata.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Encoders provide a way to convert custom Java objects into WebSocket messages and can be specified via the encoders attribute. 
 * Decoders provide a way to convert WebSocket messages to custom Java objects and can be specified via the decoders attribute.
 *  (More on this later.)
 * @author root
 *
 */
@ServerEndpoint("/chat") 
public class ChatServer {
	
	/**
	 * Use a String to receive the whole text message
	 * @param message
	 */
	@OnMessage
	public void receiveMessage(String message) 
	{
		System.out.println(message);
	}
    /**
     * Use a Java primitive or class equivalent to receive the whole message converted to that type: 
     * @param i
     */
	@OnMessage
	public void receiveMessage(int i) 
	{
		System.out.println(i);
	}
	/**
	 * Use a String and a boolean pair to receive the message in parts
	 * The Boolean parameter is true if the part received is the last part, and false otherwise
	 * @param message
	 * @param last
	 */
	@OnMessage
	public void receiveBigText(String message, boolean last) 
	{ 
		System.out.println(message);
	}
	
	/**
	 * Use a Reader to receive the whole text message as a blocking stream
	 * @param reader
	 */
	@OnMessage 
	public void processReader(Reader reader) { 
		System.out.println("Reader....");
	}
	
	/**
	 * Use byte[] or ByteBuffer to receive the whole binary message
	 * @param b
	 */
	@OnMessage 
	public void receiveMessage(ByteBuffer b) {  
		System.out.println("ByteBuffer....");
	}
	/**
	 * Use byte[] and a boolean pair, or ByteBuffer and a boolean pair, to receive the message in parts
	 * @param buf
	 * @param last
	 */
	@OnMessage 
	public void receiveBigBinary(ByteBuffer buf, boolean last) {  
		System.out.println("ByteBuffer....last");
	}
	/**
	 * Use InputStream to receive the whole binary message as a blocking stream
	 * @param stream
	 */
	@OnMessage
	public void processStream(InputStream stream) {  
		 System.out.println("InputStream....");
	}
	/**
	 * Use PongMessage to receive the pong message
	 * @param pong
	 */
	@OnMessage
	public void processPong(PongMessage pong) {  
		System.out.println("PongMessage...");
	}
	/**
	 * Session indicates a conversation between two WebSocket endpoints and represents the other end of the connection. 
	 * In this case, a response to the client may be returned: 
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void receiveMessage(String message, Session session) { 
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@OnOpen 
	public void open(Session s) {  
		System.out.println("OnOpen....");
	}
	
	@OnClose 
	public void close(CloseReason c) { 
		System.out.println("OnClose....");
	}
	
	@OnError 
	public void error(Throwable t) { 
		System.out.println("OnError....");
	}

}
