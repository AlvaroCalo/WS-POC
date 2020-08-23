package com.web.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.models.Dataconn;
import com.web.models.Meats;

public class MeatsDAO {

	public ArrayList<Meats> listMeatsDAO() {
		ArrayList<Meats> list = new ArrayList<Meats>();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM meats";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Meats mea = new Meats();
				mea.setId(rs.getInt(1));
				mea.setName(rs.getString(2));
				mea.setDescription(rs.getNString(3));
				list.add(mea);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return list;

	}

	public Meats findMeatDAO(int id) {
		Meats m = new Meats();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM meats WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setDescription(rs.getNString(3));
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return m;
	}

	public Meats deleteMeatDAO(int id) {
		boolean success = false;
		Meats m = new Meats();
		m = new MeatsDAO().findMeatDAO(id);
		Meats nullMeat = new Meats();
		
		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "DELETE FROM meats WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameter, the id to delete
			pstmt.setInt(1, id);

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);
		if (success) {
			return m;
		} else {
			return nullMeat;
		}
	}

	public boolean updateMeatNameDAO(int id, String Name) {

		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE meats SET Name = ? WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameters
			pstmt.setString(1, Name);
			pstmt.setInt(2, id);

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return success;
	}

	public boolean updateMeatDescriptionDAO(int id, String Description) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE meats SET Description = ? WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameters
			pstmt.setString(1, Description);
			pstmt.setInt(2, id);

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return success;

	}

	public boolean insertMeatDAO(Meats m) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "INSERT INTO meats (Name, Description) VALUES (?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameters
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getDescription());

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return success;
	}
}
