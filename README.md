##图片文件上传服务（基于thrift框架实现）

这个项目主要是使用facebook的thrift框架来实现二进制文件的上传，mw-image工程下分为两个模块，分别为

**1. mw-image-client 客户端**

**2. mw-image-server 服务端**

server模块主要是提供上传文件方法的具体实现，由于面向接口编程的思想，这个server模块的实现细节是不会暴露给用户的，而client会提供定义接口的方法给server去实现，并暴露接口给用户去调用。

fileData.thrift文件

```pro
// -------------------------------------------------------------------- File
struct FileData
{
    1:required string   suffixName,                   // 文件名字
    2:required string   filePath,                   // 文件上传路径
    3:required binary   fileBuff,                       // 文件数据
}

// -------------------------------------------------------------------- Service
service FileService
{
    string uploadFile(1:FileData filedata);       // 文件解析函数
}
```

以下面是mw-image-client的pom文件

```xml
<!-- rabiitmq -->
<dependency>
    <groupId>com.rabbitmq</groupId>
    <artifactId>amqp-client</artifactId>
    <version>3.6.1</version>
</dependency>
<!-- thrift -->
<dependency>
    <groupId>org.apache.thrift</groupId>
    <artifactId>libthrift</artifactId>
    <version>0.10.0</version>
</dependency>
<!--图片压缩-->
<dependency>
    <groupId>net.coobird</groupId>
    <artifactId>thumbnailator</artifactId>
    <version>0.4.8</version>
</dependency>
```

一个编程细节的思考，后面基于成功实现文件上传的基础上，给这个图片上传增加了压缩图片格式的功能。然后考虑*这个压缩图片的操作是放在client端实现还是server去完成？*最后决定，把图片压缩的操作放在了client端。

*原因：*

> 自己在网上看了一篇文件，说的就是手机上传图片的时候，是在手机本地做了压缩之后才请求到服务器端的。所以，同样的道理，对于这个项目的client需要承担图片压缩的操作。服务端不应该承担太多压力。



这个图片上传的优点

传统的文件上传一般只支持上传到web应用所在的服务器，而且会在文件写一堆业务无关的代码，下面就是没有使用这个文件上传服务的代码。

```java
//文件上传路径
String path = request.getSession().getServletContext().getRealPath("upload");
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
String uploadDate = dateFormat.format(new Date());
path = path + File.separator + uploadDate;

//上传文件名字
String extendsFileName = FileTools.getFileExtendsName(file.getOriginalFilename());
String fileName = UUID.randomUUID().toString() + extendsFileName;
File targetFile = new File(path, fileName);

//创建文件
if (!targetFile.exists()) {
    targetFile.mkdirs();
}

//保存文件
try {
    file.transferTo(targetFile);
} catch (IOException e) {
    e.printStackTrace();
}
```

下面是使用了thrift框架实现的文件上传服务的代码，一行就可以将图片上传到文件服务器.

```java
ImageUploadClient.uploadImage(file.getBytes(), file.getName());
```

mw-image-client api说明
提供了文件上传的功能

|                    方法                    |       方法描述        |                 方法参数说明                 |
| :--------------------------------------: | :---------------: | :------------------------------------: |
| RequestResult uploadImageWithFilePath(String localFilePath) |      上传本地的图片      |          localFilePath本地图片路径           |
| RequestResult uplaodImageWithFileUrl(String fileUrl) |    上传带url地址的图片    |            fileUrl 图片的url地址            |
| RequestResult uplaodImageWithFileUrlAndCompressScale(String fileUrl, float compressScale) | 上传带url地址的图片，使用了压缩 | fileUrl:图片的url地址 compressScale：图片压缩的比例 |


 

