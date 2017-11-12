// ------------------------------------------------------------------- Result
struct RequestResult
{
    1:required i32      code,                       //状态码
    2:required string   desc,                       //接口描述
    3:required string   thumbnail,
    4:required string   bmiddle,
    5:required string   original,
}
// -------------------------------------------------------------------- File
struct FileData
{
    1:required string   suffixName,                   // 文件名字
    2:required string   filePath,                     // 文件上传路径
    3:required binary   fileBuff,                     // 文件数据
}

// -------------------------------------------------------------------- Service
service FileService
{
    RequestResult uploadFile(1:FileData filedata);                 // 文件解析函数
    RequestResult uploadFile(1:list<FileData> fileDataList);       // 文件解析函数
}