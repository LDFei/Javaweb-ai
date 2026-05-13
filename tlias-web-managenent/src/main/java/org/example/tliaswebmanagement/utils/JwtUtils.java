package org.example.tliaswebmanagement.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 签名密钥（生产环境建议配合配置文件读取）
    private static String signKey = "heng";
    // 过期时间：12小时
    private static Long expire = 43200000L;

    /**
     * 生成JWT令牌
     * @param claims 封装在JWT第二部分（载荷）中的自定义数据
     * @return 令牌字符串
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims) // 设置自定义载荷
                .signWith(SignatureAlgorithm.HS256, signKey) // 设置签名算法和密钥
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // 设置有效期
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt 令牌字符串
     * @return 解析出的载荷数据
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey) // 设置签名密钥
                .parseClaimsJws(jwt) // 解析令牌
                .getBody();
        return claims;
    }
}