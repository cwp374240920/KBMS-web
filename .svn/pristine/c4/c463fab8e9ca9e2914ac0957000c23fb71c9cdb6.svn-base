package main.com.njupt.kb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import main.com.njupt.kb.dao.AssociationDao;
import main.com.njupt.kb.dao.BaseDao;
import main.com.njupt.kb.domain.AssociateFile;
import main.com.njupt.kb.domain.File;
import main.com.njupt.kb.domain.PageModel;

@Repository(value = "associationDao")
public class AssociationDaoImpl extends BaseDao implements AssociationDao {

	@Override
	public int createAssociation(String key, String info, int fid) {
		return this.getSession()
				.createSQLQuery("insert into associatefile(associateKey,information,fid) values(:key, :info, :fid)")
				.addEntity(AssociateFile.class).setParameter("key", key).setParameter("info", info)
				.setParameter("fid", fid).executeUpdate();
	}

	@Override
	public int deleteAssociation(int fid) {
		return this.getSession()
				.createSQLQuery("DELETE FROM associatefile  WHERE associateKey IN" + "(SELECT temp.associateKey FROM"
						+ "(SELECT associateKey FROM associatefile WHERE fid = :fid" + "	)temp)")
				.addEntity(AssociateFile.class).setParameter("fid", fid).executeUpdate();
	}

	@Override
	public PageModel findAssociation(int fileID, PageModel pageModel) {
		Query query = this.getSession()
				.createSQLQuery(
						"SELECT * FROM file WHERE file.id IN( SELECT associatefile.fid FROM associatefile WHERE associatefile.associateKey IN ( SELECT associatefile.associateKey FROM associatefile WHERE associatefile.fid = :fileID))")
				.addEntity(File.class)
				.setParameter("fileID", fileID);
		int total = query.list().size();
		List list =query
				.setFirstResult(pageModel.firstResult())
				.setMaxResults(pageModel.getPageSize())
				.list();
		pageModel.setTotalRecords(total);
		pageModel.setList(list);
		return pageModel;
	}

}
