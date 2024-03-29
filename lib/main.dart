import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'simple_page_widgets.dart';
import 'demoIn.dart';

void main() {
  runApp(DartDemoApp());
}

class DartDemoApp extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => _MyDartState();
}

Map<String, WidgetBuilder> routes = {
  "second": (BuildContext context) => SecondRouteWidget()
};

class _MyDartState extends State<DartDemoApp> {
  @override
  void initState() {
    super.initState();
    FlutterBoost.singleton.registerPageBuilders({
      'first': (pageName, params, _) => FirstRouteWidget(),
      'second': (pageName, params, _) => SecondRouteWidget(),
      'tab': (pageName, params, _) => TabRouteWidget(),
      'flutterFragment': (pageName, params, _) => FragmentRouteWidget(params),

      ///可以在native层通过 getContainerParams 来传递参数
      'flutterPage': (pageName, params, _) {
        print("flutterPage params:$params");

        return FlutterRouteWidget();
      },
      "default": (pageName, params, _) => DemoIn()
    });

    FlutterBoost.handleOnStartPage();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Flutter Boot example",
      builder: FlutterBoost.init(),
      routes: routes,
      home: Container(),
    );
  }
}
