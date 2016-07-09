package main.com.njupt.kb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import main.com.njupt.kb.dao.BaseDao;
import main.com.njupt.kb.dao.FileDao;
import main.com.njupt.kb.domain.AssociateFile;
import main.com.njupt.kb.domain.Category;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;
import main.com.njupt.kb.domain.User;

@Repository(value = "fileDao")
public class FileDaoImpl extends BaseDao implements FileDao {

	@Override
	public PageModel findFiles(PageModel page, int cid) {

		Query query = this.getSession().createQuery("from File f where f.category.id=:cid").setParameter("cid", cid);
		int k = query.list().size();
		List list = query.setFirstResult(page.firstResult()).setMaxResults(page.getPageSize()).list();

		page.setList(list);
		page.setTotalRecords(k);
		return page;
	}

	@Override
	public File findFile(int id) {

		return (File) this.getSession().createSQLQuery("select*from file where id=:id").addEntity(File.class)
				.setParameter("id", id).uniqueResult();

	}

	@Override
	public int add(File file) {
		/* this.getSession().save(file); */
		return this.getSession()
				.createSQLQuery(
						"insert into file(type,newName,originalName,path,cid,docPath) values(:type,:newName,:originalName,:path,:cid,:docPath)")
				.addEntity(File.class).setParameter("type", file.getType()).setParameter("newName", file.getNewName())
				.setParameter("originalName", file.getOriginalName()).setParameter("path", file.getPath())
				.setParameter("cid", file.getCategory().getId())
				.setParameter("docPath", file.getDocPath())
				.executeUpdate();

	}

	@Override
	public int delete(File file) {
		return 0;
	}

	@Override
	public PageModel findFilesByType(int userID, PageModel pageModel) {
		Query query = this.getSession()
				.createSQLQuery(
						"select*from file f where f.type=:type and cid in (select id from category c where c.uid=:uid )")
				.addEntity(File.class).setParameter("type", pageModel.getKeyword()).setParameter("uid", userID);
		int total = query.list().size();
		List list = query.setFirstResult(pageModel.firstResult()).setMaxResults(pageModel.getPageSize()).list();
		pageModel.setTotalRecords(total);
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	public PageModel findFileByKeyWord(int userID, PageModel pageModel) {
		Query query = this.getSession()
				.createSQLQuery(
						"select * from file f where (f.originalName like :originalName or f.type like :type or f.commonUse like :commonUse or f.date like :date)"
								+ "and cid in (select id from category c where c.uid=:uid)")
				.addEntity(File.class).setParameter("originalName", "%" + pageModel.getKeyword() + "%")
				.setParameter("type", "%" + pageModel.getKeyword() + "%")
				.setParameter("commonUse", "%" + pageModel.getKeyword() + "%")
				.setParameter("date",pageModel.getKeyword() + "%" )
				.setParameter("uid", userID);
		int total = query.list().size();
		List list = query.setFirstResult(pageModel.firstResult()).setMaxResults(pageModel.getPageSize()).list();
		pageModel.setTotalRecords(total);
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	public int setCommonUse(int fileID) {
		return this.getSession().createSQLQuery("update file set commonUse=:commonUse where id=:id")
				.addEntity(File.class).setParameter("commonUse", "常用").setParameter("id", fileID).executeUpdate();
	}

	@Override
	public int cancelCommonUse(int fileID) {

		return this.getSession().createSQLQuery("update file set commonUse=:commonUse where id=:id")
				.addEntity(File.class).setParameter("commonUse", null).setParameter("id", fileID).executeUpdate();
	}

	@Override
	public PageModel findCommonUseFile(int uid, PageModel pageModel) {
		Query query = this.getSession()
				.createSQLQuery(
						"select*from file f where f.commonUse=:commonUse and cid in (select id from category c where c.uid=:uid )")
				.addEntity(File.class).setParameter("commonUse", pageModel.getKeyword()).setParameter("uid", uid);
		int total = query.list().size();
		List list = query.setFirstResult(pageModel.firstResult()).setMaxResults(pageModel.getPageSize()).list();
		pageModel.setTotalRecords(total);
		pageModel.setList(list);
		return pageModel;
	}

}
