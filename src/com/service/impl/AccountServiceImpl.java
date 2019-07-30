package com.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.pojo.Account;
import com.pojo.Log;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();		
		//先判断帐号和密码是否匹配
		Account accOutSelect = session.selectOne("com.mapper.AccountMapper.selByAccnoPwd",accOut);
		if(accOutSelect!=null){
			if(accOutSelect.getBalance()>=accOut.getBalance()){
				Account accInSelect  = session.selectOne("com.mapper.AccountMapper.selByAccnoName",accIn);
				if(accInSelect!=null){
					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("com.mapper.AccountMapper.updBalanceByAccno",accOut);
					index += session.update("com.mapper.AccountMapper.updBalanceByAccno",accIn);
					if(index==2){
						//日志表记录
						Log log = new Log();
						log.setAccIn(accIn.getAccNo());
						log.setAccOut(accOut.getAccNo());
						log.setMoney(accIn.getBalance());
						session.insert("com.mapper.LogMapper.insLog",log);
						//日志文件记录
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut()+"给"+log.getAccIn()+"在"+
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"转了"+log.getMoney());
						session.commit();
						session.close();
						return SUCCESS;
					}else{
						session.rollback();
						session.close();
						return ERROR;
					}
				}else{
					return ACCOUNT_NAME_NOT_MATCH;
				}
			}else{
				//余额不足
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		}else{
			//帐号和密码不匹配
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
	}

}
