$name=$args[0]
$nameparam = "-DartifactId="+$name
mvn archetype:generate "-DgroupId=com.gabimunt.advent2021" $nameparam "-DarchetypeArtifactId=maven-archetype-quickstart" "-DinteractiveMode=false"