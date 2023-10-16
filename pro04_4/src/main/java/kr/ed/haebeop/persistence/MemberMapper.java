package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.domain.Test;
import org.apache.ibatis.annotations.*;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM member order by regdate desc")
    public List<Member> getMemberList3();

    @Select("SELECT * FROM member WHERE id = #{id}")
    public Member getMember3(String id);

    @Insert("INSERT INTO member VALUES (#{id}, #{pw}, #{name}, #{email}, #{tel}, #{addr1}, #{addr2}, #{postcode}, default, #{birth}, default, default)")
    public void insert3(Member member);

    @Update("UPDATE member SET pw=#{pw}, name=#{name}, email=#{email}, tel=#{tel}, addr1=#{addr1}, addr2=#{addr2}, postcode=#{postcode} WHERE id=#{id}")
    public void update3(Member member);

    @Delete("DELETE FROM member WHERE id = #{id}")
    public void delete3(String id);

    @Select("SELECT count(*) FROM member")
    public int memberCount();

    @Select("SELECT * FROM member WHERE id = #{id}")
    public Member signIn(String id);

    @Select("SELECT * FROM member WHERE id = #{id}")
    public Member loginCheck(String id);

    @Select("SELECT * FROM member WHERE id = #{id}")
    public Member loginAjax(Member member);
}
