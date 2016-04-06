package mail;

/**
 * Created by jason on 15/10/27.
 */
public class SendMail {

    public static void main(String[] args) {
        String smtp = "smtp.163.com";// smtp服务器
        String from = "15158100351@163.com";// 邮件显示名称
        String to = "cheng.zheng@tqmall.com";// 收件人的邮件地址，必须是真实地址
        String copyto = "";// 抄送人邮件地址
        String subject = "你好,很高兴认识你";// 邮件标题
        String content = "你好11111111111111111111111！";// 邮件内容
        String username = "15158100351@163.com";// 发件人真实的账户名
        String password = "jason150214";// 发件人密码
        Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password);
    }
}
