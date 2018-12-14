package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet(); // объявляем сервлет для обработки request'ов

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS); // handler формирует response
        context.addServlet(new ServletHolder(allRequestsServlet), "/*"); // говорим, что этот сервлет будет обрабатывать абсолютно все запросы

        Server server = new Server(8080); // стартуем сервер, это уже относится к Jetty
        server.setHandler(context); // устанавливаем Hadler для сервера,

        server.start();
        server.join();
    }
}
