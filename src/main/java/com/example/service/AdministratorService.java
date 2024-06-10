package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービス.
 *
 * @author igamasayuki
 * 
 */
@Service
@Transactional
public class AdministratorService {

  @Autowired
  private AdministratorRepository administratorRepository;

  /**
   * 管理者情報を登録します.
   *
   * @param administrator 管理者情報
   */
  public void insert(Administrator administrator) {
    administratorRepository.insert(administrator);
  }

  /**
   * ログインをします.
   *
   * @param mailAddress メールアドレス
   * @param password    パスワード
   * @return 管理者情報 存在しない場合はnullが返ります
   */
  public Administrator login(String mailAddress, String password) {
    Administrator administrator = administratorRepository.findByMailAddress(mailAddress);
    if (administrator == null || !new BCryptPasswordEncoder().matches(password, administrator.getPassword()))
      return null;
    return administrator;
  }

  /**
   * データベースにメールアドレスに対応する管理者が存在するかを返します.
   *
   * @param mailAddress メールアドレス
   * @return 存在するかのBoolean
   */
  public boolean isExistingAdministratorByMailAddress(String mailAddress) {
    return administratorRepository.findByMailAddress(mailAddress) != null;
  }
}
