/*
 Navicat Premium Data Transfer

 Source Server         : ghost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 127.0.0.1:3306
 Source Schema         : k15

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 14/12/2022 14:32:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bili_lists
-- ----------------------------
DROP TABLE IF EXISTS `bili_lists`;
CREATE TABLE `bili_lists`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `bvid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `cid` int(0) DEFAULT NULL,
  `arcurl` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `imagsss` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bili_lists
-- ----------------------------
INSERT INTO `bili_lists` VALUES (1, '凛子同学提不起劲', '小凛的书记舞绝对不可能这么可爱( *｀ω´)！！', 'BV1Gv4y1P7L9', 1, 'http://www.bilibili.com/video/av554378673', NULL);
INSERT INTO `bili_lists` VALUES (2, '平安银行信用卡', '心跳光谱决赛圈  ❤️ 甜 过 爱 你 ❤️', 'BV13A4y1Z758', 2, 'http://www.bilibili.com/video/av896891902', NULL);
INSERT INTO `bili_lists` VALUES (3, '果哝双子', '双胞胎魔性蹦迪！嗨到不行！（派对浪客诸葛孔明OP）', 'BV1JA4y1Z74w', 3, 'http://www.bilibili.com/video/av896921145', NULL);
INSERT INTO `bili_lists` VALUES (4, '箜月Tsuki', '谁能拒绝会跳舞的杀手妈咪！Killer Lady-约尔·福杰-箜月', 'BV1uA4y1Z73J', 1, 'http://www.bilibili.com/video/av896880894', NULL);
INSERT INTO `bili_lists` VALUES (5, '六弧muko', '【六弧】天城燐音 U.S.A.【cos完整速翻！！】', 'BV1TF41157v1', 1, 'http://www.bilibili.com/video/av299460567', NULL);
INSERT INTO `bili_lists` VALUES (6, 'これなんでneko_日昙', '☁️夏色笑容1、2、Jump!☁️但是香子兰（？）【lovelive】夏色えがおで1、2、Jump!', 'BV1BA4y1d76J', 1, 'http://www.bilibili.com/video/av897110726', NULL);
INSERT INTO `bili_lists` VALUES (7, '远牧acyulu', '删号合集-翎霜', 'BV1QS4y1q7aC', 1, 'http://www.bilibili.com/video/av727077091', NULL);
INSERT INTO `bili_lists` VALUES (8, '夜喵w', '肉肉脸学妹 为了你我可以不毕业嘛！！🤤🤤🤤', 'BV1xt4y1p76L', 2, 'http://www.bilibili.com/video/av982038578', NULL);
INSERT INTO `bili_lists` VALUES (9, '反白嫖艺术家', '这绝对是你见过的最像原版的极乐净土', 'BV1qB4y1X7tY', 2, 'http://www.bilibili.com/video/av597088045', NULL);
INSERT INTO `bili_lists` VALUES (10, '浙江大学', '【浙江省6校联投】浙里有您的心动快递❤《心跳光谱》❤2022BDF', 'BV11g411o7GC', 2, 'http://www.bilibili.com/video/av511939473', NULL);
INSERT INTO `bili_lists` VALUES (11, '荣小兔头', '爱 杀 （手）宝 贝', 'BV1K94y1m7gQ', 2, 'http://www.bilibili.com/video/av342098885', NULL);
INSERT INTO `bili_lists` VALUES (12, '圈个柿子', '路人大爷：这个小姑娘笑的真甜【BDF2022闪耀回响】', 'BV1mZ4y1b7PH', 3, 'http://www.bilibili.com/video/av384513134', NULL);
INSERT INTO `bili_lists` VALUES (13, 'TheMix多语种乐团', '哔哩哔哩向前冲我们来啦！来自音乐区的整活舞蹈【新宝岛】', 'BV1YZ4y1b7YY', 3, 'http://www.bilibili.com/video/av384470011', NULL);
INSERT INTO `bili_lists` VALUES (14, 'senko老司机', '【senko】这有奶茶的七分甜吗？还是你的笑容最可爱', 'BV1GS4y1q7gA', 3, 'http://www.bilibili.com/video/av726953772', NULL);
INSERT INTO `bili_lists` VALUES (15, '卑微的苏崽崽', '谁会拒绝一只会跳舞的海嗣~    《神的随波逐流》', 'BV1p341137NH', 3, 'http://www.bilibili.com/video/av427042412', NULL);
INSERT INTO `bili_lists` VALUES (16, '外村莓', '【ノンフィクション!!（nonfiction）】动画版liella全员part！（≧∇≦）', 'BV1RW4y1k7j4', 3, 'http://www.bilibili.com/video/av939552957', NULL);
INSERT INTO `bili_lists` VALUES (17, '热爱吃饭的琳琳', '【琳琳】马儿跳传说 初投稿 录舞试水', 'BV1NT4y1B7TP', 3, 'http://www.bilibili.com/video/av939476285', NULL);
INSERT INTO `bili_lists` VALUES (18, '寒十十十', '纪念一下第一次跳宅舞和第一次投稿', 'BV1mZ4y1b7Na', 1, 'http://www.bilibili.com/video/av384513058', NULL);
INSERT INTO `bili_lists` VALUES (19, '笑微微来了', '白胡桃带小提琴跳极乐净土(ﾉ≧∀≦)ﾉ', 'BV1gF41157cP', 2, 'http://www.bilibili.com/video/av299435533', NULL);
INSERT INTO `bili_lists` VALUES (20, '則尾_', '【则尾】es扒舞U.S.A.-和蜂邮一起在时代广场嘎嘎阿美莉卡', 'BV1Av4y1w7rN', 2, 'http://www.bilibili.com/video/av554518666', NULL);
INSERT INTO `bili_lists` VALUES (21, 'baka爱', '阿 波 呆 同 学 |【baka爱】阿波连ed翻跳 竖屏', 'BV19B4y1Q7qA', 2, 'http://www.bilibili.com/video/av596916512', NULL);
INSERT INTO `bili_lists` VALUES (22, 'MONAMISA', '【Saber旗袍COS】桃源恋歌 - GARNiDELiA | 宅舞翻跳【MONAMISA】', 'BV1JA4y1Z7Z4', 2, 'http://www.bilibili.com/video/av896918813', NULL);
INSERT INTO `bili_lists` VALUES (23, '粽子淞', '【粽子淞】闪耀回响｜寻找属于你的颜色', 'BV1T541197cW', 3, 'http://www.bilibili.com/video/av469495958', NULL);
INSERT INTO `bili_lists` VALUES (24, 'absoluteoo', 'just dance', 'BV1CF41157gK', 3, 'http://www.bilibili.com/video/av299548089', NULL);
INSERT INTO `bili_lists` VALUES (25, '咲岚', '【咲岚】♪心跳光谱♪ 是刻在心底永恒的光芒～生日作～', 'BV14Z4y1b77R', 3, 'http://www.bilibili.com/video/av384448556', NULL);
INSERT INTO `bili_lists` VALUES (26, 'Maka酱', '【竖屏】❤️Are you ready ？天真烂漫机能【五月病退散】', 'BV1mS4y1q7qg', 1, 'http://www.bilibili.com/video/av727032945', NULL);
INSERT INTO `bili_lists` VALUES (27, '是雯雯不是文文_', '【雯雯】心跳光谱★生日作+一周年快乐！', 'BV1jZ4y1b7ov', 2, 'http://www.bilibili.com/video/av384415427', NULL);
INSERT INTO `bili_lists` VALUES (28, '结城初音', '[衿儿]マダママゴト-正镜头', 'BV1AB4y1X7zV', 2, 'http://www.bilibili.com/video/av596942950', NULL);
INSERT INTO `bili_lists` VALUES (29, '相思才不是咸鱼酱', '雷 神 斩 灭 剑！有这样的妹妹你几点回家？埃罗芒阿老师OP⁽⁽ଘ自言自语ଓ⁾⁾【咸鱼酱】', 'BV1RT4y1q7Ls', 3, 'http://www.bilibili.com/video/av939443385', NULL);
INSERT INTO `bili_lists` VALUES (30, '小桶妹', '你的软萌女仆发来一条消息❤️竖屏~(≧∇≦)～喵', 'BV1Ka411j7At', 1, 'http://www.bilibili.com/video/av214453450', NULL);
INSERT INTO `bili_lists` VALUES (31, '_沫洛_', '【U.S.A.】康忙 北鼻 阿美莉卡！放我去es大楼蹦迪', 'BV1MY4y1B7RK', 1, 'http://www.bilibili.com/video/av639397515', NULL);
INSERT INTO `bili_lists` VALUES (32, '江南大学本科招生', '【BDF2022×江南大学】心跳光谱❤️高考倒计时10天！点亮梦想，你我都在闪耀着光芒！', 'BV1v5411X7zA', 1, 'http://www.bilibili.com/video/av469393892', NULL);
INSERT INTO `bili_lists` VALUES (33, '几兔灰', '元气炸弹★我的偶像宣言☆站上舞台闪闪发光吧！', 'BV19a411j7Db', 2, 'http://www.bilibili.com/video/av214575661', NULL);
INSERT INTO `bili_lists` VALUES (34, '小褶褶er', '三种超甜学妹你选择哪一款❤️闪耀回响❤️', 'BV1z94y1S7dh', 3, 'http://www.bilibili.com/video/av342080777', NULL);
INSERT INTO `bili_lists` VALUES (35, '冰蕾栀子', '见过心海跳舞嘛！！！！#宅舞', 'BV1N5411Q7Nk', 4, 'http://www.bilibili.com/video/av469623412', NULL);
INSERT INTO `bili_lists` VALUES (36, '饭饭小丸叽', '【丹青】两个皮肤的西施喜欢哪一个？甩纱球~王者荣耀COS！', 'BV1S5411X7Ba', 4, 'http://www.bilibili.com/video/av469412290', NULL);
INSERT INTO `bili_lists` VALUES (37, '粽子淞', '【粽子淞/原创编舞】愛言葉IV - DECO*27.ver', 'BV1eg411o7iY', 4, 'http://www.bilibili.com/video/av511909681', NULL);
INSERT INTO `bili_lists` VALUES (38, '中国矿业大学本科招生', '【BDF2022-中国矿大】❤️心跳光谱❤️来矿大追寻你的梦想吧！', 'BV1eZ4y1b7m5', 4, 'http://www.bilibili.com/video/av384473989', NULL);
INSERT INTO `bili_lists` VALUES (39, '招商银行App', '你一定可以答对这道题~【爱的谜题】', 'BV1W34y177Yh', 4, 'http://www.bilibili.com/video/av812083593', NULL);
INSERT INTO `bili_lists` VALUES (40, '坎蒂猴', '大海、制服与少女 / 只给予你的晴天【坎蒂】', 'BV1s54y1o7Xh', 4, 'http://www.bilibili.com/video/av854463295', NULL);
INSERT INTO `bili_lists` VALUES (41, '萦夜yoru', '新学妹要来报道啦！！【BDF2022⭐闪耀回响】', 'BV1NB4y1X7bc', 1, 'http://www.bilibili.com/video/av596985966', NULL);
INSERT INTO `bili_lists` VALUES (42, '4SplllitS', '【瞬间】U.S.A//这一拳将开拓胜利的道路…', 'BV1EA4y1Z7vT', 2, 'http://www.bilibili.com/video/av896916296', NULL);
INSERT INTO `bili_lists` VALUES (43, '金鱼mystery', '【三千金】你要给我定多重的罪♡恋爱裁判♡', 'BV1pg411o7Pz', 2, 'http://www.bilibili.com/video/av511897733', NULL);
INSERT INTO `bili_lists` VALUES (44, '是三衿吖', '【三衿】隔离小区楼下跳一跳 心跳光谱 解封无望', 'BV1KT4y1B7o1', 3, 'http://www.bilibili.com/video/av939486921', NULL);
INSERT INTO `bili_lists` VALUES (45, '岚西啊喵', '【岚西】cat loving″喵~请温柔一点抚摸我', 'BV1Jt4y1s7Ri', 3, 'http://www.bilibili.com/video/av981913978', NULL);
INSERT INTO `bili_lists` VALUES (46, '龙冽', '【龙冽】小恶魔嘉然~可爱的女朋友  キュートなカノジョ', 'BV1A94y1S72m', 3, 'http://www.bilibili.com/video/av341995319', NULL);
INSERT INTO `bili_lists` VALUES (47, '阿里云盘', '【求盘！】同学，能帮你保管资料吗？测不准的阿波连同学ED舞蹈', 'BV1h34y1j7K5', 3, 'http://www.bilibili.com/video/av811912681', NULL);
INSERT INTO `bili_lists` VALUES (48, '三点水www', '喜欢！雪！真实的魔法！', 'BV13U4y1y7f7', 4, 'http://www.bilibili.com/video/av684459860', NULL);
INSERT INTO `bili_lists` VALUES (49, 'Aki秋酱-', '5w粉感谢作！  来和我一起去油菜花田里玩耍吧～( ´▽` )ﾉMarine Dreamin', 'BV1r3411V7dD', 4, 'http://www.bilibili.com/video/av426973726', NULL);
INSERT INTO `bili_lists` VALUES (50, '池野欣欣子', '【欣子】染上你的颜色｜小树林里的制服小可爱向你告白！( ๑˃̶ ꇴ ˂̶)♪⁺', 'BV1UF411V78J', 4, 'http://www.bilibili.com/video/av299397522', NULL);
INSERT INTO `bili_lists` VALUES (51, 'ADM动漫社', '【A.D.M动漫社】暴太郎战队op舞/俺こそオンリーワン—翻跳', 'BV1Hr4y1x7Fx', 4, 'http://www.bilibili.com/video/av769532686', NULL);
INSERT INTO `bili_lists` VALUES (52, 'LENivayaAya_官方频道', 'aya💜超级敏感❤️全与你有关(〃\'▽\'〃)', 'BV1d3411G7it', 4, 'http://www.bilibili.com/video/av426859754', NULL);
INSERT INTO `bili_lists` VALUES (53, '一只浣兮吖_', '早上6点没睡醒的໒๑ᵒᯅᵒ๑ ১快乐合成器', 'BV1RF411V7Sk', 1, 'http://www.bilibili.com/video/av299424862', NULL);
INSERT INTO `bili_lists` VALUES (54, 'HanaSuer', '【Hana酥】18岁生日作⭐️我的偶像宣言 私、アイドル宣言⭐️新一岁的小偶像可以成为你的推吗！', 'BV12v4y1A7xm', 2, 'http://www.bilibili.com/video/av554332159', NULL);
INSERT INTO `bili_lists` VALUES (55, '金鱼mystery', '【金鱼】可以邀你一起赏月吗☾千里邀月【单人一镜到底】', 'BV1TT4y1B7x7', 3, 'http://www.bilibili.com/video/av939484308', NULL);
INSERT INTO `bili_lists` VALUES (56, 'bubby姬', '【T3特供】去寻找属于自己的颜色❤', 'BV1cA4y1f7Ye', 4, 'http://www.bilibili.com/video/av897056038', NULL);
INSERT INTO `bili_lists` VALUES (57, '足太姬', '【YakoPen】好朋友的舞步', 'BV1kS4y1z7Pm', 1, 'http://www.bilibili.com/video/av726915313', NULL);
INSERT INTO `bili_lists` VALUES (58, '今天小开开了吗', '【17岁生日作】想变得可爱！【投稿两周年纪念】五套换装~无缝衔接~', 'BV1xB4y1R7u5', 2, 'http://www.bilibili.com/video/av596883279', NULL);
INSERT INTO `bili_lists` VALUES (59, '白粥yono', '哪部动画是你的童年?动画串烧❤爷青回 六一特辑【白粥yono】', 'BV1EY411g7Yd', 3, 'http://www.bilibili.com/video/av257112149', NULL);
INSERT INTO `bili_lists` VALUES (60, '七河みこ', '【みこ】青空のラプソディ/青空的狂想曲【女仆装】', 'BV16u41167ta', 4, 'http://www.bilibili.com/video/av511647162', NULL);
INSERT INTO `bili_lists` VALUES (61, '喵扑果酱', '四年后我看起来更小了怎么办 | Drop Pop Candy | 喵扑果酱', 'BV1z5411X7Xh', 1, 'http://www.bilibili.com/video/av469379079', NULL);
INSERT INTO `bili_lists` VALUES (62, '祝勺子', '震惊！高中地理老师竟然跳恋dance助力高考！', 'BV1YY411u7wp', 2, 'http://www.bilibili.com/video/av256993193', NULL);
INSERT INTO `bili_lists` VALUES (63, '结城初音', '[衿儿]マダママゴト-远镜头', 'BV1T94y1S71p', 1, 'http://www.bilibili.com/video/av341972209', NULL);
INSERT INTO `bili_lists` VALUES (64, '圆脸水牛', '神的随波逐流/宿舍翻跳', 'BV13L4y1K7bo', 2, 'http://www.bilibili.com/video/av854603648', NULL);
INSERT INTO `bili_lists` VALUES (65, '一只可可洛', '是谁的DNA又动了!❤️美少女战士热舞', 'BV1FF411L7EA', 3, 'http://www.bilibili.com/video/av299600308', NULL);
INSERT INTO `bili_lists` VALUES (66, '结城初音', '[衿儿]被害妄想携帯女子(笑)-正镜头', 'BV1BA4y1Z7Hq', 4, 'http://www.bilibili.com/video/av896975537', NULL);
INSERT INTO `bili_lists` VALUES (67, '早上好七七', '偶遇这样的女生你要不要来搭讪一下呀~', 'BV1KA4y1f77D', 1, 'http://www.bilibili.com/video/av897039488', NULL);
INSERT INTO `bili_lists` VALUES (68, '五菱新能源青岛体验店', '【舞】大厂运营内卷不如在加我一个！让我们感谢半佛老师！黑丝最安全！', 'BV1Wv4y1w7Bw', 2, 'http://www.bilibili.com/video/av554583723', NULL);
INSERT INTO `bili_lists` VALUES (69, 'Vitality晓汐', 'Jk学姐版～还是你的笑容最可爱「晓汐」', 'BV1oF411V71h', 3, 'http://www.bilibili.com/video/av299427073', NULL);
INSERT INTO `bili_lists` VALUES (70, '若薇还没想好昵称', '【若薇】寄明月|原神刻晴cos|在学校社团游园会上起舞～', 'BV1xY4y1z7sD', 4, 'http://www.bilibili.com/video/av639613358', NULL);
INSERT INTO `bili_lists` VALUES (71, '久煊tozi', '魈宝   《恋爱循环》   你们知道我掉了多少零件吗？（不要注意我肩上内个东西QAQ）', 'BV1R5411X7y7', 1, 'http://www.bilibili.com/video/av469460160', NULL);
INSERT INTO `bili_lists` VALUES (72, 'Kitaro绮太郎', '✨坚持闪耀 寻找属于自己的颜色   ✨BDF2022闪耀回响✨', 'BV1Dg411R7Fm', 2, 'http://www.bilibili.com/video/av512124193', NULL);
INSERT INTO `bili_lists` VALUES (73, 'SayaScarlet', '原神cos 【Saya Scarlet】ツギハギスタッカート ☆ 拼凑的断音', 'BV15Z4y1b7xH', 2, 'http://www.bilibili.com/video/av384406572', NULL);
INSERT INTO `bili_lists` VALUES (74, '谢临川川川川川川', '【谢临川】偷钻嫦娥姐姐的衣柜！林间小鹿撞进你心里没(///▽///)?还是你的笑容最可爱捏！', 'BV18g411o7sk', 3, 'http://www.bilibili.com/video/av511922238', NULL);
INSERT INTO `bili_lists` VALUES (75, 'MONAMISA', '【黑Saber COS】Lamb | 宅舞翻跳【MONAMISA】', 'BV1GW4y1C7bN', 4, 'http://www.bilibili.com/video/av939610806', NULL);
INSERT INTO `bili_lists` VALUES (76, '咲岚', '【GGKD】♪心跳光谱♪【BDF2022-江西南昌】', 'BV1wY4y1V7w4', 1, 'http://www.bilibili.com/video/av641997029', NULL);
INSERT INTO `bili_lists` VALUES (77, '黑糖梅', '大 · 梦 · 仙 · 缘｜国风五人原创编舞', 'BV1H34y1j7Va', 2, 'http://www.bilibili.com/video/av811876430', NULL);
INSERT INTO `bili_lists` VALUES (78, '岛崎nori', '40岁，带不太聪明的女儿跳【牛奶颂】【noguri】', 'BV1x341137jr', 1, 'http://www.bilibili.com/video/av427087983', NULL);
INSERT INTO `bili_lists` VALUES (79, 'MONAMISA', '【2B COS】Girls | 宅舞翻跳【MONAMISA】', 'BV1Jv4y1P7qE', 2, 'http://www.bilibili.com/video/av554403549', NULL);
INSERT INTO `bili_lists` VALUES (80, 'LENivayaAya_官方频道', 'aya🍯sweet magic🍯超元气甜妹！谁会不心动！！！', 'BV1fY411F7DT', 4, 'http://www.bilibili.com/video/av256901118', NULL);
INSERT INTO `bili_lists` VALUES (81, '球球明天就减肥', '两个风格的小短腿喜欢哪个呢~闪耀回响~【球球】', 'BV1i5411D7aR', 1, 'http://www.bilibili.com/video/av469502068', NULL);
INSERT INTO `bili_lists` VALUES (82, '废柴懒懒奈', '我的DNA动了！童年回忆Smile☆光之美少女yeah！yeah！yeah！', 'BV1EZ4y1b7GY', 2, 'http://www.bilibili.com/video/av384452219', NULL);
INSERT INTO `bili_lists` VALUES (83, '沅柚YOYO', '咸鱼少女-三倍可爱小小鹿，大家一起过六一（＾Ｏ＾☆♪', 'BV1334y177p5', 3, 'http://www.bilibili.com/video/av812042645', NULL);
INSERT INTO `bili_lists` VALUES (84, '钉宫草莓', '软萌Q弹双马尾！( •̀ ω •́ )✧兔兔这么可爱不可以吃！【钉宫草莓】', 'BV1WY411u7Gc', 2, 'http://www.bilibili.com/video/av256965510', NULL);
INSERT INTO `bili_lists` VALUES (85, '小黎咩咩', '【小黎】开心超人舞  |  对于小学生觉得幼稚，但是对于大学生来说刚刚好！', 'BV1aU4y127ZR', 1, 'http://www.bilibili.com/video/av684395074', NULL);
INSERT INTO `bili_lists` VALUES (86, '晨二1呀', '这位同学，我能去你家坐坐吗？❤阿波连同学ed舞', 'BV1TT4y1B7Li', 1, 'http://www.bilibili.com/video/av939485894', NULL);

-- ----------------------------
-- Table structure for rbac_perms
-- ----------------------------
DROP TABLE IF EXISTS `rbac_perms`;
CREATE TABLE `rbac_perms`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parentid` int(0) DEFAULT NULL,
  `type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'm:菜单 p：数据',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '1:正常 2：禁用',
  `percode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_ParentID`(`parentid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 69 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_perms
-- ----------------------------
INSERT INTO `rbac_perms` VALUES (26, '权限管理', 'right/manager', NULL, NULL, 'm', 'y', NULL, 'el-icon-set-up');
INSERT INTO `rbac_perms` VALUES (27, '权限列表', 'right/list', 'right', 26, 'm', 'y', 'right:list', NULL);
INSERT INTO `rbac_perms` VALUES (28, '新增权限', 'right/add', 'right/add', 27, 'p', 'y', 'right:add', NULL);
INSERT INTO `rbac_perms` VALUES (29, '删除权限', 'right/delete', 'right/delete', 27, 'p', 'y', 'right:delete', NULL);
INSERT INTO `rbac_perms` VALUES (30, '修改权限', 'right/update', 'right/update', 27, 'p', 'y', 'right:update', NULL);
INSERT INTO `rbac_perms` VALUES (42, '用户管理', 'user/manager', NULL, NULL, 'm', 'y', NULL, 'el-icon-user');
INSERT INTO `rbac_perms` VALUES (43, '用户列表', 'user/list', 'user', 42, 'm', 'y', 'user:list', NULL);
INSERT INTO `rbac_perms` VALUES (44, '新增用户', 'user/add', 'user/add', 43, 'p', 'y', 'user:add', NULL);
INSERT INTO `rbac_perms` VALUES (45, '修改用户', 'user/update', 'user/update', 43, 'p', 'y', 'user:update', NULL);
INSERT INTO `rbac_perms` VALUES (46, '删除用户', 'user/delete', 'user/delete', 43, 'p', 'y', 'user:delete', NULL);
INSERT INTO `rbac_perms` VALUES (55, '视频管理', 'video/manager', NULL, NULL, 'm', 'y', NULL, 'el-icon-user');
INSERT INTO `rbac_perms` VALUES (56, '视频列表', 'video/list', 'video', 55, 'm', 'y', 'video:list', NULL);
INSERT INTO `rbac_perms` VALUES (57, '修改视频', 'video/update', 'video/update', 56, 'p', 'y', 'video:update', NULL);
INSERT INTO `rbac_perms` VALUES (58, '删除视频', 'video/delete', 'video/delete', 56, 'p', 'y', 'video:delete', NULL);
INSERT INTO `rbac_perms` VALUES (59, '添加视频', 'video/add', 'video/add', 56, 'p', 'y', 'video:add', NULL);

-- ----------------------------
-- Table structure for rbac_user
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user`;
CREATE TABLE `rbac_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_user
-- ----------------------------
INSERT INTO `rbac_user` VALUES (1, 'tom', '$2a$10$R3c/LjjYYfHulwRCuXyCnuU9UdsL5YxnyphyJP35zKioarJWl.Jky', 'y', 'zhangsan@qq.com');
INSERT INTO `rbac_user` VALUES (2, 'lisi3', '$2a$10$R3c/LjjYYfHulwRCuXyCnuU9UdsL5YxnyphyJP35zKioarJWl.Jky', 'y', 'lisi@qq.com');
INSERT INTO `rbac_user` VALUES (3, 'admin', '$2a$10$R3c/LjjYYfHulwRCuXyCnuU9UdsL5YxnyphyJP35zKioarJWl.Jky', 'y', 'xiaokongming@qq.com');
INSERT INTO `rbac_user` VALUES (4, 'zhangsan', '$2a$10$R3c/LjjYYfHulwRCuXyCnuU9UdsL5YxnyphyJP35zKioarJWl.Jky', 'y', 'lisi@qq.com');
INSERT INTO `rbac_user` VALUES (5, 'lisi', '$2a$10$R3c/LjjYYfHulwRCuXyCnuU9UdsL5YxnyphyJP35zKioarJWl.Jky', 'y', 'lisi@qq.com');

-- ----------------------------
-- Table structure for rbac_user_perm
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_perm`;
CREATE TABLE `rbac_user_perm`  (
  `userid` int(0) NOT NULL,
  `permid` int(0) NOT NULL,
  PRIMARY KEY (`userid`, `permid`) USING BTREE,
  INDEX `FK_PERMID2`(`permid`) USING BTREE,
  CONSTRAINT `FK_PERMID2` FOREIGN KEY (`permid`) REFERENCES `rbac_perms` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_USERID2` FOREIGN KEY (`userid`) REFERENCES `rbac_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rbac_user_perm
-- ----------------------------
INSERT INTO `rbac_user_perm` VALUES (3, 26);
INSERT INTO `rbac_user_perm` VALUES (5, 26);
INSERT INTO `rbac_user_perm` VALUES (3, 27);
INSERT INTO `rbac_user_perm` VALUES (5, 27);
INSERT INTO `rbac_user_perm` VALUES (3, 28);
INSERT INTO `rbac_user_perm` VALUES (5, 28);
INSERT INTO `rbac_user_perm` VALUES (3, 29);
INSERT INTO `rbac_user_perm` VALUES (5, 29);
INSERT INTO `rbac_user_perm` VALUES (3, 30);
INSERT INTO `rbac_user_perm` VALUES (5, 30);
INSERT INTO `rbac_user_perm` VALUES (3, 42);
INSERT INTO `rbac_user_perm` VALUES (3, 43);
INSERT INTO `rbac_user_perm` VALUES (3, 44);
INSERT INTO `rbac_user_perm` VALUES (3, 45);
INSERT INTO `rbac_user_perm` VALUES (3, 46);
INSERT INTO `rbac_user_perm` VALUES (5, 55);
INSERT INTO `rbac_user_perm` VALUES (5, 56);
INSERT INTO `rbac_user_perm` VALUES (5, 57);
INSERT INTO `rbac_user_perm` VALUES (5, 58);
INSERT INTO `rbac_user_perm` VALUES (5, 59);

SET FOREIGN_KEY_CHECKS = 1;
