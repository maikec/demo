package handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.time.LocalDate;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/1
 */
public class TimeServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String str = message.toString();
        if( str.trim().equalsIgnoreCase("quit") ) {
            session.close(true);
            return;
        }

        LocalDate date = LocalDate.now();
        session.write( date.toString() );
        System.out.println("Message written...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }
}
