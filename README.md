#### Steps to reproduce:

- Make `"com.github.qaemma" % "common" % "0.1-SNAPSHOT"` available in local with:

```
cd proto-gen
sbt publishLocal
```

- Compile on `client`, which get the proto files from `common` and try to compile:

```
cd client
sbt compile
```

- Here's the error messages:

```
common/common.proto:12:31: "com.qaemma.proto.common.Name.first_name" is already defined in file "com/github/qaemma/common/common.proto".
common/common.proto:13:31: "com.qaemma.proto.common.Name.last_name" is already defined in file "com/github/qaemma/common/common.proto".
common/common.proto:11:9: "com.qaemma.proto.common.Name" is already defined in file "com/github/qaemma/common/common.proto".
```

- This works fine if I have them in `src/main/protobuf` instead of importing from an external jar.
