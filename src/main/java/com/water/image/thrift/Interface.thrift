// -------------------------------------------------------------------- File
struct FileData
{
    1:required string   filename,                   // 文件名字
    2:required string   filepath,                   // 文件上传路径
    3:required binary   buff,                       // 文件数据
}

// -------------------------------------------------------------------- Service

service FileService
{
    string uploadFile(1:FileData filedata);       // 文件解析函数
}