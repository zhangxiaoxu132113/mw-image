package com.water.image.client.model;

/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-11-10")
public class RequestResult implements org.apache.thrift.TBase<RequestResult, RequestResult._Fields>, java.io.Serializable, Cloneable, Comparable<RequestResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RequestResult");

  private static final org.apache.thrift.protocol.TField CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("code", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DESC_FIELD_DESC = new org.apache.thrift.protocol.TField("desc", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField THUMBNAIL_FIELD_DESC = new org.apache.thrift.protocol.TField("thumbnail", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField BMIDDLE_FIELD_DESC = new org.apache.thrift.protocol.TField("bmiddle", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField ORIGINAL_FIELD_DESC = new org.apache.thrift.protocol.TField("original", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RequestResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RequestResultTupleSchemeFactory();

  public int code; // required
  public String desc; // required
  public String thumbnail; // required
  public String bmiddle; // required
  public String original; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CODE((short)1, "code"),
    DESC((short)2, "desc"),
    THUMBNAIL((short)3, "thumbnail"),
    BMIDDLE((short)4, "bmiddle"),
    ORIGINAL((short)5, "original");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CODE
          return CODE;
        case 2: // DESC
          return DESC;
        case 3: // THUMBNAIL
          return THUMBNAIL;
        case 4: // BMIDDLE
          return BMIDDLE;
        case 5: // ORIGINAL
          return ORIGINAL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __CODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CODE, new org.apache.thrift.meta_data.FieldMetaData("code", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DESC, new org.apache.thrift.meta_data.FieldMetaData("desc", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.THUMBNAIL, new org.apache.thrift.meta_data.FieldMetaData("thumbnail", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BMIDDLE, new org.apache.thrift.meta_data.FieldMetaData("bmiddle", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ORIGINAL, new org.apache.thrift.meta_data.FieldMetaData("original", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RequestResult.class, metaDataMap);
  }

  public RequestResult() {
  }

  public RequestResult(
    int code,
    String desc,
    String thumbnail,
    String bmiddle,
    String original)
  {
    this();
    this.code = code;
    setCodeIsSet(true);
    this.desc = desc;
    this.thumbnail = thumbnail;
    this.bmiddle = bmiddle;
    this.original = original;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RequestResult(RequestResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.code = other.code;
    if (other.isSetDesc()) {
      this.desc = other.desc;
    }
    if (other.isSetThumbnail()) {
      this.thumbnail = other.thumbnail;
    }
    if (other.isSetBmiddle()) {
      this.bmiddle = other.bmiddle;
    }
    if (other.isSetOriginal()) {
      this.original = other.original;
    }
  }

  public RequestResult deepCopy() {
    return new RequestResult(this);
  }

  @Override
  public void clear() {
    setCodeIsSet(false);
    this.code = 0;
    this.desc = null;
    this.thumbnail = null;
    this.bmiddle = null;
    this.original = null;
  }

  public int getCode() {
    return this.code;
  }

  public RequestResult setCode(int code) {
    this.code = code;
    setCodeIsSet(true);
    return this;
  }

  public void unsetCode() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  /** Returns true if field code is set (has been assigned a value) and false otherwise */
  public boolean isSetCode() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CODE_ISSET_ID);
  }

  public void setCodeIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CODE_ISSET_ID, value);
  }

  public String getDesc() {
    return this.desc;
  }

  public RequestResult setDesc(String desc) {
    this.desc = desc;
    return this;
  }

  public void unsetDesc() {
    this.desc = null;
  }

  /** Returns true if field desc is set (has been assigned a value) and false otherwise */
  public boolean isSetDesc() {
    return this.desc != null;
  }

  public void setDescIsSet(boolean value) {
    if (!value) {
      this.desc = null;
    }
  }

  public String getThumbnail() {
    return this.thumbnail;
  }

  public RequestResult setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
    return this;
  }

  public void unsetThumbnail() {
    this.thumbnail = null;
  }

  /** Returns true if field thumbnail is set (has been assigned a value) and false otherwise */
  public boolean isSetThumbnail() {
    return this.thumbnail != null;
  }

  public void setThumbnailIsSet(boolean value) {
    if (!value) {
      this.thumbnail = null;
    }
  }

  public String getBmiddle() {
    return this.bmiddle;
  }

  public RequestResult setBmiddle(String bmiddle) {
    this.bmiddle = bmiddle;
    return this;
  }

  public void unsetBmiddle() {
    this.bmiddle = null;
  }

  /** Returns true if field bmiddle is set (has been assigned a value) and false otherwise */
  public boolean isSetBmiddle() {
    return this.bmiddle != null;
  }

  public void setBmiddleIsSet(boolean value) {
    if (!value) {
      this.bmiddle = null;
    }
  }

  public String getOriginal() {
    return this.original;
  }

  public RequestResult setOriginal(String original) {
    this.original = original;
    return this;
  }

  public void unsetOriginal() {
    this.original = null;
  }

  /** Returns true if field original is set (has been assigned a value) and false otherwise */
  public boolean isSetOriginal() {
    return this.original != null;
  }

  public void setOriginalIsSet(boolean value) {
    if (!value) {
      this.original = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CODE:
      if (value == null) {
        unsetCode();
      } else {
        setCode((Integer)value);
      }
      break;

    case DESC:
      if (value == null) {
        unsetDesc();
      } else {
        setDesc((String)value);
      }
      break;

    case THUMBNAIL:
      if (value == null) {
        unsetThumbnail();
      } else {
        setThumbnail((String)value);
      }
      break;

    case BMIDDLE:
      if (value == null) {
        unsetBmiddle();
      } else {
        setBmiddle((String)value);
      }
      break;

    case ORIGINAL:
      if (value == null) {
        unsetOriginal();
      } else {
        setOriginal((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CODE:
      return getCode();

    case DESC:
      return getDesc();

    case THUMBNAIL:
      return getThumbnail();

    case BMIDDLE:
      return getBmiddle();

    case ORIGINAL:
      return getOriginal();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CODE:
      return isSetCode();
    case DESC:
      return isSetDesc();
    case THUMBNAIL:
      return isSetThumbnail();
    case BMIDDLE:
      return isSetBmiddle();
    case ORIGINAL:
      return isSetOriginal();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof RequestResult)
      return this.equals((RequestResult)that);
    return false;
  }

  public boolean equals(RequestResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_code = true;
    boolean that_present_code = true;
    if (this_present_code || that_present_code) {
      if (!(this_present_code && that_present_code))
        return false;
      if (this.code != that.code)
        return false;
    }

    boolean this_present_desc = true && this.isSetDesc();
    boolean that_present_desc = true && that.isSetDesc();
    if (this_present_desc || that_present_desc) {
      if (!(this_present_desc && that_present_desc))
        return false;
      if (!this.desc.equals(that.desc))
        return false;
    }

    boolean this_present_thumbnail = true && this.isSetThumbnail();
    boolean that_present_thumbnail = true && that.isSetThumbnail();
    if (this_present_thumbnail || that_present_thumbnail) {
      if (!(this_present_thumbnail && that_present_thumbnail))
        return false;
      if (!this.thumbnail.equals(that.thumbnail))
        return false;
    }

    boolean this_present_bmiddle = true && this.isSetBmiddle();
    boolean that_present_bmiddle = true && that.isSetBmiddle();
    if (this_present_bmiddle || that_present_bmiddle) {
      if (!(this_present_bmiddle && that_present_bmiddle))
        return false;
      if (!this.bmiddle.equals(that.bmiddle))
        return false;
    }

    boolean this_present_original = true && this.isSetOriginal();
    boolean that_present_original = true && that.isSetOriginal();
    if (this_present_original || that_present_original) {
      if (!(this_present_original && that_present_original))
        return false;
      if (!this.original.equals(that.original))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + code;

    hashCode = hashCode * 8191 + ((isSetDesc()) ? 131071 : 524287);
    if (isSetDesc())
      hashCode = hashCode * 8191 + desc.hashCode();

    hashCode = hashCode * 8191 + ((isSetThumbnail()) ? 131071 : 524287);
    if (isSetThumbnail())
      hashCode = hashCode * 8191 + thumbnail.hashCode();

    hashCode = hashCode * 8191 + ((isSetBmiddle()) ? 131071 : 524287);
    if (isSetBmiddle())
      hashCode = hashCode * 8191 + bmiddle.hashCode();

    hashCode = hashCode * 8191 + ((isSetOriginal()) ? 131071 : 524287);
    if (isSetOriginal())
      hashCode = hashCode * 8191 + original.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RequestResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCode()).compareTo(other.isSetCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.code, other.code);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDesc()).compareTo(other.isSetDesc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDesc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.desc, other.desc);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetThumbnail()).compareTo(other.isSetThumbnail());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetThumbnail()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.thumbnail, other.thumbnail);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBmiddle()).compareTo(other.isSetBmiddle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBmiddle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bmiddle, other.bmiddle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOriginal()).compareTo(other.isSetOriginal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOriginal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.original, other.original);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("RequestResult(");
    boolean first = true;

    sb.append("code:");
    sb.append(this.code);
    first = false;
    if (!first) sb.append(", ");
    sb.append("desc:");
    if (this.desc == null) {
      sb.append("null");
    } else {
      sb.append(this.desc);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("thumbnail:");
    if (this.thumbnail == null) {
      sb.append("null");
    } else {
      sb.append(this.thumbnail);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("bmiddle:");
    if (this.bmiddle == null) {
      sb.append("null");
    } else {
      sb.append(this.bmiddle);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("original:");
    if (this.original == null) {
      sb.append("null");
    } else {
      sb.append(this.original);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'code' because it's a primitive and you chose the non-beans generator.
    if (desc == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'desc' was not present! Struct: " + toString());
    }
    if (thumbnail == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'thumbnail' was not present! Struct: " + toString());
    }
    if (bmiddle == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'bmiddle' was not present! Struct: " + toString());
    }
    if (original == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'original' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RequestResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RequestResultStandardScheme getScheme() {
      return new RequestResultStandardScheme();
    }
  }

  private static class RequestResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<RequestResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RequestResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.code = iprot.readI32();
              struct.setCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DESC
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.desc = iprot.readString();
              struct.setDescIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // THUMBNAIL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.thumbnail = iprot.readString();
              struct.setThumbnailIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BMIDDLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.bmiddle = iprot.readString();
              struct.setBmiddleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ORIGINAL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.original = iprot.readString();
              struct.setOriginalIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetCode()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'code' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, RequestResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CODE_FIELD_DESC);
      oprot.writeI32(struct.code);
      oprot.writeFieldEnd();
      if (struct.desc != null) {
        oprot.writeFieldBegin(DESC_FIELD_DESC);
        oprot.writeString(struct.desc);
        oprot.writeFieldEnd();
      }
      if (struct.thumbnail != null) {
        oprot.writeFieldBegin(THUMBNAIL_FIELD_DESC);
        oprot.writeString(struct.thumbnail);
        oprot.writeFieldEnd();
      }
      if (struct.bmiddle != null) {
        oprot.writeFieldBegin(BMIDDLE_FIELD_DESC);
        oprot.writeString(struct.bmiddle);
        oprot.writeFieldEnd();
      }
      if (struct.original != null) {
        oprot.writeFieldBegin(ORIGINAL_FIELD_DESC);
        oprot.writeString(struct.original);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RequestResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RequestResultTupleScheme getScheme() {
      return new RequestResultTupleScheme();
    }
  }

  private static class RequestResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<RequestResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RequestResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.code);
      oprot.writeString(struct.desc);
      oprot.writeString(struct.thumbnail);
      oprot.writeString(struct.bmiddle);
      oprot.writeString(struct.original);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RequestResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.code = iprot.readI32();
      struct.setCodeIsSet(true);
      struct.desc = iprot.readString();
      struct.setDescIsSet(true);
      struct.thumbnail = iprot.readString();
      struct.setThumbnailIsSet(true);
      struct.bmiddle = iprot.readString();
      struct.setBmiddleIsSet(true);
      struct.original = iprot.readString();
      struct.setOriginalIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

