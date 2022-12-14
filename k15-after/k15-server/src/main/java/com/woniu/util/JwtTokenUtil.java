package com.woniu.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
public class JwtTokenUtil {

    // 过期时间 30 分钟
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

//    private static final long EXPIRE_TIME =  15 * 1000;

    // jwt 签名密钥
    private static final String SECRET = "woniuxy";


    /**
     * 生成 token
     * @param username
     * @return
     */
    public static String createToken(String username) {
        String tocken = null;
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        try {
            tocken = JWT.create()
                    .withAudience(username)         // 将username保存到token里面
                    .withExpiresAt(date)            // tocken 过期时间
//                    .withClaim("testClaim", "testClaim")
//                    .withSubject("JWT_Token")
                    .sign(Algorithm.HMAC256(SECRET));    // 签名加密方式
        } catch (Exception e) {
            log.error("token生成异常", e);
        }
        return tocken;
    }

    /**
     * 校验 token
     * @param token
     * @return
     */
    public static boolean checkToken(String token) {
        try {
            JWTVerifier verifier = JWT
                    .require(Algorithm.HMAC256(SECRET))     // 签名加密方式
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("token无效，请重新获取", e);
            return false;
        }
    }

    /**
     * 根据token获取username
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            String username = JWT.decode(token).getAudience().get(0);
            return username;
        } catch (JWTDecodeException e) {
            log.error("token异常", e);
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        String token = JwtTokenUtil.createToken("tonny");
        System.out.println(token);

//        String[] strArr = token.split("\\.");
//        System.out.println("Header：" + new String(Base64.decodeBase64(strArr[0]), "UTF-8"));
//        System.out.println("Claims：" + new String(Base64.decodeBase64(strArr[1]), "UTF-8"));

        // 篡改 token 的结果
//        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZXN0Q2xhaW0iOiJ0ZXN0Q2xhaW0iLCJhdWQiOiJ0b25ueSIsInN1YiI6IkpXVF9Ub2tlbiIsImV4cCI6MTY1NTE5Mzc2NH0.j_loI8K8Pxee_JbqTB0f_Mx8t94uSpybzZ0GXHJk7Lo" + 0;
//        boolean sss = checkToken(token);
//        System.out.println(sss);

        token = token + 'a';
        checkToken(token);
//        while(checkToken(token)) {
//            System.out.println("==============================>" + System.currentTimeMillis());
//            Thread.sleep(1000);
//        }
//        System.out.println("过期后：" + getUsername(token));
    }
}
