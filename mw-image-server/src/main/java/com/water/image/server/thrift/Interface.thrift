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