/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package cn.slimsmart.thrift.rpc.demo;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2017-6-8")
public class WorldViewTileResp implements org.apache.thrift.TBase<WorldViewTileResp, WorldViewTileResp._Fields>, java.io.Serializable, Cloneable, Comparable<WorldViewTileResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("WorldViewTileResp");

  private static final org.apache.thrift.protocol.TField INFOS_FIELD_DESC = new org.apache.thrift.protocol.TField("infos", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField PLAYER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("playerId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField IS_END_PACKET_FIELD_DESC = new org.apache.thrift.protocol.TField("isEndPacket", org.apache.thrift.protocol.TType.BOOL, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new WorldViewTileRespStandardSchemeFactory());
    schemes.put(TupleScheme.class, new WorldViewTileRespTupleSchemeFactory());
  }

  public List<WorldTileData> infos; // required
  public long playerId; // required
  public boolean isEndPacket; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INFOS((short)1, "infos"),
    PLAYER_ID((short)2, "playerId"),
    IS_END_PACKET((short)3, "isEndPacket");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // INFOS
          return INFOS;
        case 2: // PLAYER_ID
          return PLAYER_ID;
        case 3: // IS_END_PACKET
          return IS_END_PACKET;
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
  private static final int __PLAYERID_ISSET_ID = 0;
  private static final int __ISENDPACKET_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INFOS, new org.apache.thrift.meta_data.FieldMetaData("infos", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "WorldTileData"))));
    tmpMap.put(_Fields.PLAYER_ID, new org.apache.thrift.meta_data.FieldMetaData("playerId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.IS_END_PACKET, new org.apache.thrift.meta_data.FieldMetaData("isEndPacket", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(WorldViewTileResp.class, metaDataMap);
  }

  public WorldViewTileResp() {
  }

  public WorldViewTileResp(
    List<WorldTileData> infos,
    long playerId,
    boolean isEndPacket)
  {
    this();
    this.infos = infos;
    this.playerId = playerId;
    setPlayerIdIsSet(true);
    this.isEndPacket = isEndPacket;
    setIsEndPacketIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public WorldViewTileResp(WorldViewTileResp other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetInfos()) {
      List<WorldTileData> __this__infos = new ArrayList<WorldTileData>(other.infos.size());
      for (WorldTileData other_element : other.infos) {
        __this__infos.add(other_element);
      }
      this.infos = __this__infos;
    }
    this.playerId = other.playerId;
    this.isEndPacket = other.isEndPacket;
  }

  public WorldViewTileResp deepCopy() {
    return new WorldViewTileResp(this);
  }

  @Override
  public void clear() {
    this.infos = null;
    setPlayerIdIsSet(false);
    this.playerId = 0;
    setIsEndPacketIsSet(false);
    this.isEndPacket = false;
  }

  public int getInfosSize() {
    return (this.infos == null) ? 0 : this.infos.size();
  }

  public java.util.Iterator<WorldTileData> getInfosIterator() {
    return (this.infos == null) ? null : this.infos.iterator();
  }

  public void addToInfos(WorldTileData elem) {
    if (this.infos == null) {
      this.infos = new ArrayList<WorldTileData>();
    }
    this.infos.add(elem);
  }

  public List<WorldTileData> getInfos() {
    return this.infos;
  }

  public WorldViewTileResp setInfos(List<WorldTileData> infos) {
    this.infos = infos;
    return this;
  }

  public void unsetInfos() {
    this.infos = null;
  }

  /** Returns true if field infos is set (has been assigned a value) and false otherwise */
  public boolean isSetInfos() {
    return this.infos != null;
  }

  public void setInfosIsSet(boolean value) {
    if (!value) {
      this.infos = null;
    }
  }

  public long getPlayerId() {
    return this.playerId;
  }

  public WorldViewTileResp setPlayerId(long playerId) {
    this.playerId = playerId;
    setPlayerIdIsSet(true);
    return this;
  }

  public void unsetPlayerId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PLAYERID_ISSET_ID);
  }

  /** Returns true if field playerId is set (has been assigned a value) and false otherwise */
  public boolean isSetPlayerId() {
    return EncodingUtils.testBit(__isset_bitfield, __PLAYERID_ISSET_ID);
  }

  public void setPlayerIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PLAYERID_ISSET_ID, value);
  }

  public boolean isIsEndPacket() {
    return this.isEndPacket;
  }

  public WorldViewTileResp setIsEndPacket(boolean isEndPacket) {
    this.isEndPacket = isEndPacket;
    setIsEndPacketIsSet(true);
    return this;
  }

  public void unsetIsEndPacket() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISENDPACKET_ISSET_ID);
  }

  /** Returns true if field isEndPacket is set (has been assigned a value) and false otherwise */
  public boolean isSetIsEndPacket() {
    return EncodingUtils.testBit(__isset_bitfield, __ISENDPACKET_ISSET_ID);
  }

  public void setIsEndPacketIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISENDPACKET_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INFOS:
      if (value == null) {
        unsetInfos();
      } else {
        setInfos((List<WorldTileData>)value);
      }
      break;

    case PLAYER_ID:
      if (value == null) {
        unsetPlayerId();
      } else {
        setPlayerId((Long)value);
      }
      break;

    case IS_END_PACKET:
      if (value == null) {
        unsetIsEndPacket();
      } else {
        setIsEndPacket((Boolean)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INFOS:
      return getInfos();

    case PLAYER_ID:
      return Long.valueOf(getPlayerId());

    case IS_END_PACKET:
      return Boolean.valueOf(isIsEndPacket());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INFOS:
      return isSetInfos();
    case PLAYER_ID:
      return isSetPlayerId();
    case IS_END_PACKET:
      return isSetIsEndPacket();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof WorldViewTileResp)
      return this.equals((WorldViewTileResp)that);
    return false;
  }

  public boolean equals(WorldViewTileResp that) {
    if (that == null)
      return false;

    boolean this_present_infos = true && this.isSetInfos();
    boolean that_present_infos = true && that.isSetInfos();
    if (this_present_infos || that_present_infos) {
      if (!(this_present_infos && that_present_infos))
        return false;
      if (!this.infos.equals(that.infos))
        return false;
    }

    boolean this_present_playerId = true;
    boolean that_present_playerId = true;
    if (this_present_playerId || that_present_playerId) {
      if (!(this_present_playerId && that_present_playerId))
        return false;
      if (this.playerId != that.playerId)
        return false;
    }

    boolean this_present_isEndPacket = true;
    boolean that_present_isEndPacket = true;
    if (this_present_isEndPacket || that_present_isEndPacket) {
      if (!(this_present_isEndPacket && that_present_isEndPacket))
        return false;
      if (this.isEndPacket != that.isEndPacket)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_infos = true && (isSetInfos());
    list.add(present_infos);
    if (present_infos)
      list.add(infos);

    boolean present_playerId = true;
    list.add(present_playerId);
    if (present_playerId)
      list.add(playerId);

    boolean present_isEndPacket = true;
    list.add(present_isEndPacket);
    if (present_isEndPacket)
      list.add(isEndPacket);

    return list.hashCode();
  }

  @Override
  public int compareTo(WorldViewTileResp other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetInfos()).compareTo(other.isSetInfos());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInfos()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.infos, other.infos);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlayerId()).compareTo(other.isSetPlayerId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlayerId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.playerId, other.playerId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIsEndPacket()).compareTo(other.isSetIsEndPacket());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsEndPacket()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isEndPacket, other.isEndPacket);
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
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("WorldViewTileResp(");
    boolean first = true;

    sb.append("infos:");
    if (this.infos == null) {
      sb.append("null");
    } else {
      sb.append(this.infos);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("playerId:");
    sb.append(this.playerId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("isEndPacket:");
    sb.append(this.isEndPacket);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
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

  private static class WorldViewTileRespStandardSchemeFactory implements SchemeFactory {
    public WorldViewTileRespStandardScheme getScheme() {
      return new WorldViewTileRespStandardScheme();
    }
  }

  private static class WorldViewTileRespStandardScheme extends StandardScheme<WorldViewTileResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, WorldViewTileResp struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INFOS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.infos = new ArrayList<WorldTileData>(_list0.size);
                WorldTileData _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new WorldTileData();
                  _elem1.read(iprot);
                  struct.infos.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setInfosIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PLAYER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.playerId = iprot.readI64();
              struct.setPlayerIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // IS_END_PACKET
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isEndPacket = iprot.readBool();
              struct.setIsEndPacketIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, WorldViewTileResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.infos != null) {
        oprot.writeFieldBegin(INFOS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.infos.size()));
          for (WorldTileData _iter3 : struct.infos)
          {
            _iter3.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PLAYER_ID_FIELD_DESC);
      oprot.writeI64(struct.playerId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(IS_END_PACKET_FIELD_DESC);
      oprot.writeBool(struct.isEndPacket);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class WorldViewTileRespTupleSchemeFactory implements SchemeFactory {
    public WorldViewTileRespTupleScheme getScheme() {
      return new WorldViewTileRespTupleScheme();
    }
  }

  private static class WorldViewTileRespTupleScheme extends TupleScheme<WorldViewTileResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, WorldViewTileResp struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetInfos()) {
        optionals.set(0);
      }
      if (struct.isSetPlayerId()) {
        optionals.set(1);
      }
      if (struct.isSetIsEndPacket()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetInfos()) {
        {
          oprot.writeI32(struct.infos.size());
          for (WorldTileData _iter4 : struct.infos)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetPlayerId()) {
        oprot.writeI64(struct.playerId);
      }
      if (struct.isSetIsEndPacket()) {
        oprot.writeBool(struct.isEndPacket);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, WorldViewTileResp struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.infos = new ArrayList<WorldTileData>(_list5.size);
          WorldTileData _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new WorldTileData();
            _elem6.read(iprot);
            struct.infos.add(_elem6);
          }
        }
        struct.setInfosIsSet(true);
      }
      if (incoming.get(1)) {
        struct.playerId = iprot.readI64();
        struct.setPlayerIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.isEndPacket = iprot.readBool();
        struct.setIsEndPacketIsSet(true);
      }
    }
  }

}
