# tomcat-relaxed-chars-issue
spring boot: Invalid character found in the request target

All tests pass:
- unit [HelloControllerTest](https://github.com/dirkdeyne/tomcat-relaxed-chars-issue/blob/issue/src/test/java/com/example/HelloControllerTest.java)
- integration [HelloIntegrationTest](https://github.com/dirkdeyne/tomcat-relaxed-chars-issue/blob/issue/src/test/java/com/example/HelloIntegrationTest.java)
- htmlunit [HelloHtmlUnitTest](https://github.com/dirkdeyne/tomcat-relaxed-chars-issue/blob/issue/src/test/java/com/example/HelloHtmlUnitTest.java)

But when we make actual call via browser we get an error

```
2019-06-10 20:52:37.664  INFO 10128 --- [nio-8080-exec-2] o.apache.coyote.http11.Http11Processor   : Error parsing HTTP request header
 Note: further occurrences of HTTP request parsing errors will be logged at DEBUG level.

java.lang.IllegalArgumentException: Invalid character found in the request target. The valid characters are defined in RFC 7230 and RFC 3986
  at org.apache.coyote.http11.Http11InputBuffer.parseRequestLine(Http11InputBuffer.java:467) ~[tomcat-embed-core-9.0.19.jar:9.0.19]
  at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:294) ~[tomcat-embed-core-9.0.19.jar:9.0.19]
  at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:66) [tomcat-embed-core-9.0.19.jar:9.0.19]
  at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:836) [tomcat-embed-core-9.0.19.jar:9.0.19]
  at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1747) [tomcat-embed-core-9.0.19.jar:9.0.19]
  at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.19.jar:9.0.19]
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_162]
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_162]
  at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.19.jar:9.0.19]
  at java.lang.Thread.run(Thread.java:748) [na:1.8.0_162]
```
