// module.exports = {
//     version: '1.0.0',
//     //配置
//     deployTo52:{
//         ssh: {
//             host: '192.168.4.52',
//             port: 22,
//             username: 'yanbao',
//             password: 'yanbao',
//         },
//         scp: {
//             host: "192.168.4.52",
//             username: "yanbao",
//             port: "22",
//             password: "yanbao",
//             readyTimeout: 60000,
//             dest: "/home/yanbao/tomcat/quote_server/webapps",
//             watch: function(client) {
//               client.on('close', function(o) {
//                 const d = new Date();
//                 console.log('['+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds()+'] 文件部署结束');
//               });
//             }
//         },
//         remoteDir: `/home/yanbao/tomcat/quote_server/webapps`,
//         commands: [
//             //删除现有文件
//             `rm -rf /home/yanbao/tomcat/quote_server/webapps/app/`,
//             `rm -rf /home/yanbao/tomcat/quote_server/webapps/asstes/`
//         ]
//     },
//     deployTo148:{
//         ssh: {
//             host: '58.68.247.148',
//             port: 10088,
//             username: 'cxpt',
//             password: 'cxpt@123',
//         },
//         scp: {
//             host: "58.68.247.148",
//             username: "cxpt",
//             port: "10088",
//             password: "cxpt@123",
//             readyTimeout: 60000,
//             dest: "/home/cxpt/tomcat/quote_server/webapps",
//             watch: function(client) {
//               client.on('close', function(o) {
//                 const d = new Date();
//                 console.log('['+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds()+'] 文件部署结束');
//               });
//             }
//         },
//         remoteDir: `/home/cxpt/tomcat/quote_server/webapps`,
//         commands: [
//             //删除现有文件
//             `rm -rf /home/cxpt/tomcat/quote_server/webapps/app/`,
//             `rm -rf /home/cxpt/tomcat/quote_server/webapps/assets/`
//         ]
//     },
//     deployTo145:{
//         ssh: {
//             host: '58.68.247.145',
//             port: 10088,
//             username: 'cxpt',
//             password: 'cxpt@123',
//         },
//         scp: {
//             host: "58.68.247.145",
//             username: "cxpt",
//             port: "10088",
//             password: "cxpt@123",
//             readyTimeout: 60000,
//             dest: "/home/cxpt/tomcat/quote_server/webapps",
//             watch: function(client) {
//               client.on('close', function(o) {
//                 const d = new Date();
//                 console.log('['+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds()+'] 文件部署结束');
//               });
//             }
//         },
//         remoteDir: `/home/cxpt/tomcat/quote_server/webapps`,
//         commands: [
//             //删除现有文件
//             `rm -rf /home/cxpt/tomcat/quote_server/webapps/app/`,
//             `rm -rf /home/cxpt/tomcat/quote_server/webapps/assets/`
//         ]
//     }
// };