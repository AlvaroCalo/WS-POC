package com.web.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.models.Dataconn;
import com.web.models.Fruits;

public class FruitsDAO {

	public ArrayList<Fruits> listFruitsDAO() {

		ArrayList<Fruits> list = new ArrayList<Fruits>();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM fruits";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Fruits fru = new Fruits();
				fru.setId(rs.getInt(1));
				fru.setName(rs.getString(2));
				fru.setDescription(rs.getNString(3));
				list.add(fru);
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

	public Fruits findFruitDAO(int id) {

		Fruits fr = new Fruits();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM fruits WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				fr.setId(rs.getInt(1));
				fr.setName(rs.getString(2));
				fr.setDescription(rs.getString(3));
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

		return fr;
	}

	public Fruits deleteFruitDAO(int id) {
		boolean success = false;
		Fruits fr = new Fruits();
		fr = new FruitsDAO().findFruitDAO(id);
		Fruits nullFruit = new Fruits();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "DELETE FROM `fruits` WHERE Id = ?";

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
			return fr;
		} else {
			return nullFruit;
		}
	}

	public boolean updateFruitNameDAO(int id, String Name) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE fruits SET Name = ? WHERE Id = ?";

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

	public boolean updateFruitDescriptionDAO(int id, String Description) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE fruits SET Description = ? WHERE Id = ?";

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

	public boolean insertFruitDAO(Fruits f) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "INSERT INTO fruits (Name, Description) VALUES (?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameters
			pstmt.setString(1, f.getName());
			pstmt.setString(2, f.getDescription());

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
