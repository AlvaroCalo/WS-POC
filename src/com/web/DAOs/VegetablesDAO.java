package com.web.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.models.Dataconn;
import com.web.models.Vegetables;

public class VegetablesDAO {

	public ArrayList<Vegetables> listVegetablesDAO() {
		ArrayList<Vegetables> list = new ArrayList<Vegetables>();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM vegetables";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vegetables veg = new Vegetables();
				veg.setId(rs.getInt(1));
				veg.setName(rs.getString(2));
				veg.setDescription(rs.getNString(3));
				list.add(veg);
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

	public Vegetables findVegetableDAO(int id) {
		Vegetables veg = new Vegetables();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id, Name, Description FROM vegetables WHERE Id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				veg.setId(rs.getInt(1));
				veg.setName(rs.getString(2));
				veg.setDescription(rs.getString(3));
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

		return veg;
	}

	public Vegetables deleteVegetableDAO(int id) {
		boolean success = false;
		Vegetables v = new Vegetables();
		v = new VegetablesDAO().findVegetableDAO(id);
		Vegetables nullVegetable = new Vegetables();
		
		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "DELETE FROM vegetables WHERE Id = ?";

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
			return v;
		} else {
			return nullVegetable;
		}
	}

	public boolean updateVegetableNameDAO(int id, String Name) {

		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE vegetables SET Name = ? WHERE Id = ?";

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

	public boolean updateVegetableDescriptionDAO(int id, String Description) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE vegetables SET Description = ? WHERE Id = ?";

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

	public boolean insertVegetableDAO(Vegetables v) {
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "INSERT INTO vegetables (Name, Description) VALUES (?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// The parameters
			pstmt.setString(1, v.getName());
			pstmt.setString(2, v.getDescription());

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
