// Generated file. Do not edit.

def scriptFile = getClass().protectionDomain.codeSource.location.toURI()
def flutterProjectRoot = new File(scriptFile).parentFile.parentFile
println "--------------------------------------------------------------------------"
println flutterProjectRoot.getAbsolutePath()
println "--------------------------------------------------------------------------"

gradle.include ':flutter'
gradle.project(':flutter').projectDir = new File(flutterProjectRoot, '.android/Flutter')

def plugins = new Properties()
def pluginsFile = new File(flutterProjectRoot, '.flutter-plugins')
if (pluginsFile.exists()) {
    pluginsFile.withReader('UTF-8') { reader -> plugins.load(reader) }
}

plugins.each { name, path ->
    def pluginDirectory = flutterProjectRoot.toPath().resolve(path).resolve('android').toFile()
    gradle.include ":$name"
    gradle.project(":$name").projectDir = pluginDirectory
    println "--------------------------------------------------------------------------"
    println pluginDirectory.getAbsolutePath()
    println "--------------------------------------------------------------------------"
}

gradle.getGradle().projectsLoaded { g ->
    g.rootProject.beforeEvaluate { p ->
        _mainModuleName = binding.variables['mainModuleName']
        println "--------------------------------------------------------------------------"
        println p
        println _mainModuleName
        println "--------------------------------------------------------------------------"
        if (_mainModuleName != null && !_mainModuleName.empty) {
            p.ext.mainModuleName = _mainModuleName
        }
    }
    g.rootProject.afterEvaluate { p ->
        p.subprojects { sp ->
            println ">>>>>>--------------------------------------------------------------------------"
            println sp
            println sp.name
            println ">>>>>>--------------------------------------------------------------------------"
            if (sp.name != 'flutter') {
                //既让所有子工程运行配置阶段开始之前都要保证flutter工程的配置阶段都已经运行完毕
                //这样做的好处就是保证flutter工程的配置属性优先导入，防止其他子工程出现属性找不到的问题发生
                sp.evaluationDependsOn(':flutter')
            }
        }
    }
}
