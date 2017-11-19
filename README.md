# javafx-springboot-example
A hello world javafx example using spring boot

## Description
This javafx program uses spring and spring boot to have dependency injection
and autoconfiguration capabilities.

The general functionality is that it presents an empty window with
a button that, when pressed, fetches a list of data items from a remote
servie. For the purpose of this example, we fetch sports events. In order to have
this working, you need to have the [simple-json-web-service](https://github.com/spyridon-ninos/simple-json-web-service)
running (with the default settings; if not then adjust the application.yml
file on both apps).

After the events are fetched, a table view is populated with the list.


