import handler.TcpClientHandler;
import org.apache.mina.core.RuntimeIoException;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/4
 */
public class TcpClient {
    private static final String HOST = "127.0.0.1";
    private static final Integer PORT = 9123;
    public static void main(String[] args) throws InterruptedException {
        //IoConnector
        final NioSocketConnector connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(3*1000);
        //IoFilter
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(
//      ProtocolCodecFactory
                        new ObjectSerializationCodecFactory()));
        connector.getFilterChain().addLast("logger",new LoggingFilter());

        //IoHandler
        connector.setHandler(new TcpClientHandler());

        IoSession session = null;

        for (;;){
            try {
                //IoFuture
                final ConnectFuture connectFuture = connector.connect(new InetSocketAddress(HOST, PORT));

                connectFuture.awaitUninterruptibly();

                session = connectFuture.getSession();
                break;
            }catch (RuntimeIoException e){
                System.err.println("failed connected");
                e.printStackTrace();
                Thread.sleep(5000);
            }

            //
            session.getCloseFuture().awaitUninterruptibly();
            //IoProcessor
            connector.dispose();
        }
    }
}
