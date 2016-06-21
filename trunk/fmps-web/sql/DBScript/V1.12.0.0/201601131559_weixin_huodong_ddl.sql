delete from weixin_huodong  where  accountid='8a828ebb4883613201488364bc510001' and `type` = 2 ;

update weixin_huodong h set h.title='2016春节活动', h.description = '1.  凡抽中“春节来回路费”字眼的用户，可凭票根报销来回路费（限本人机票，火车票）。</br>
2.  路费上限1000元，低于1000元按票根金额实报，高于1000元按1000元报销。</br>
3.  用户将票根寄于我司，核对无误后我司将通过用户的微信账号进行转账返还。仅接受2月1号~2月15号的票根报销。</br>
4.  票根报销时间限定为：2月15~22号，一星期为限。逾期作废。</br>
5.  中奖用户将票根寄往【福建省厦门市思明区湖滨北路101号商业银行大厦4楼4A富邦财险】电子商务部。联系电话0592-5353666-51143。</br>',
h.prizesuper='来回路费',h.supertotal=4,h.prizeone='20元红包',h.onetotal=50,h.prizetwo='10元红包',h.twototal=200,h.prizethree='5元红包',h.threetotal=400,
 h.gl='664/10000',h.`type`='2',h.accountid='8a828ebb4883613201488364bc510001' where h.id='8a828edfedfre68475034fd3dca5799634' ;