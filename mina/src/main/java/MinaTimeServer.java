import handler.TimeServerHandler;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/1
 */
public class MinaTimeServer {
    private static final int PORT = 9123;

    private static final Logger LOGGER = LoggerFactory.getLogger(MinaTimeServer.class);
    public static void main(String[] args) throws IOException {
        final IoAcceptor acceptor = new NioSocketAcceptor();
        //IoFilter
        acceptor.getFilterChain().addLast("logger",new LoggingFilter());
        acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(
                //ProtocolCodecFactory
                new TextLineCodecFactory(Charset.forName("UTF-8"))));
        //IoHandler
        acceptor.setHandler(new TimeServerHandler());
        //IoService
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,10);

        acceptor.bind(new InetSocketAddress(PORT));
        LOGGER.info("服务端启动成功，端口：{}",PORT);
    }
}
