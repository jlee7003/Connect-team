1)pom.xml
  pom에 마이바티스를 위한 라이브러리들을 추가한다

        <!-- myBatis 사용을 위한 라이브러리들 -->
            <!-- myBatis -->
            <dependency>
              <groupId>org.mybatis</groupId>
              <artifactId>mybatis</artifactId>
              <version>${mybatis-version}</version>
            </dependency>

            <!-- myBatis-spring (Spring 에서 myBatis 사용을 위한 라이브러리) -->
            <dependency>
              <groupId>org.mybatis</groupId>
              <artifactId>mybatis-spring</artifactId>
              <version>${mybatis-spring-version}</version>
            </dependency>
        
 2)servlet-context.xml
 mybatis를 사용하기 위한 bean servlet-context에 추가하기
 
          <!-- mybatis를 위한 소스 -->
          <beans:bean name="dataSource"
            class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <beans:property name="driverClassName"
              value="com.mysql.jdbc.Driver" />
            <beans:property name="url"  
              value="jdbc:mysql://localhost:3307/connect" />
            <beans:property name="username" value="root" />
            <beans:property name="password" value="1234" />
          </beans:bean>

          <beans:bean name="sqlSessionFactory"
            class="org.mybatis.spring.SqlSessionFactoryBean">
            <beans:property name="dataSource" ref="dataSource"></beans:property>
            <beans:property name="mapperLocations"
              value="classpath:kr/co/connect/mapper/*.xml"></beans:property>
            <!-- mapper의 로케이션 위치를 말함(변경해야함)
                 위의 로케이션은 내가 sql쿼리문을 작성할 xml파일의 위치를 말하는 것
            
            -->  <!-- 패키지이름: 중요=> 바뀐다 -->
          </beans:bean>

          <beans:bean name="sqlSession"
            class="org.mybatis.spring.SqlSessionTemplate">
            <beans:constructor-arg ref="sqlSessionFactory"></beans:constructor-arg>
          </beans:bean>


3)Interface File


      public interface imemberDao 
      {
         // 사용할 메소드를 추상메소드로 정의 한다.
        //interface는 자기자신의 생성자를 만들수 없다

          public ArrayList<Member> list(); 
          public Member content(String id);
      //	  Dto에 있는 레코드들을 배열로 저장하기 위해서 arraylist를 사용한다.
          //mapping 되어 있는 dao.xml에서 쿼리문을 실행시켜줌

          public Member update(Member member);

            public void updateok(String name ,String title ,String content ,String id);

          public void write(Member dto, HttpServletRequest request);

        public Member findpwd(String phone, String username, String email); 
        
       public void delete(String id);
        //내가 매개변수로 주는 값이 #{param}이 된다.
       /* ex)   <delete id="delete">
               DELETE FROM BOARD WHERE ID=#{PARAM1}
             </delete>
             */

      }
      
 4.xmlFile
 
<mapper namespace="kr.co.connect.member.dao.imemberDao"> <!--servlet-context.xml에서 내가 설정한 package의 모든 xml을 찾는다  -->
  
 <insert id="write"><!-- 인터페이스에서 정의한 메소드의 이름을 아이디로 해준다. -->
	INSERT INTO MEMBERS(USERNAME,PHONE,EMAIL,PASSWORD,BIRTH,SEX,GROUPS,WRITEDAY)
			VALUES(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param7},NOW())
	</insert>

<!--  -->
   <select id="list" resultType="kr.co.connect.member.Member"> <!--resulttype은 ResultSet 대체 라고 보면된다 -->
     SELECT * FROM BOARD ORDER BY ID DESC
   </select>
   
    <select id="content" resultType="kr.co.connect.member.Member">
     SELECT * FROM BOARD WHERE ID=#{PARAM1}
   </select>
   
   <select id="update" resultType="kr.co.connect.member.Member">
     SELECT * FROM BOARD WHERE ID=#{PARAM1}
   </select>
   
     <select id="findid" resultType="kr.co.connect.member.Member">
  	 SELECT * FROM MEMBERS WHERE PHONE=#{param1} AND USERNAME=#{param2}
   </select>
   
      <select id="findpwd" resultType="kr.co.connect.member.Member">
  	 SELECT * FROM MEMBERS WHERE PHONE=#{param1} AND USERNAME=#{param2} AND EMAIL=#{param3}
   </select>
   
   <select id="login" resultType="kr.co.connect.member.Member">
  	 SELECT * FROM MEMBERS WHERE EMAIL=#{param1} AND PASSWORD=#{param2}
   </select>

   <update id="updateok" > <!--resulttype은 ResultSet 대체 라고 보면된다 -->
     UPDATE BOARD SET NAME=#{param1},TITLE=#{param2},CONTENT=#{param3} WHERE ID=#{param4}
   </update>
   
   <delete id="delete"> <!--resulttype은 ResultSet 대체 라고 보면된다 -->
     DELETE FROM BOARD WHERE ID=#{PARAM1}
   </delete>
</mapper>
